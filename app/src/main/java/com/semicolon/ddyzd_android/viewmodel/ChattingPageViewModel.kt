package com.semicolon.ddyzd_android.viewmodel

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.semicolon.ddyzd_android.BaseApi
import com.semicolon.ddyzd_android.adapter.ChattingAdapter
import com.semicolon.ddyzd_android.model.ChattingData
import com.semicolon.ddyzd_android.ul.activity.ChattingPage
import com.semicolon.ddyzd_android.viewmodel.MainViewModel.Companion.accessToken
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.socket.client.IO
import io.socket.client.Manager
import io.socket.client.Socket
import io.socket.emitter.Emitter
import io.socket.engineio.client.Transport
import org.json.JSONObject
import java.net.URISyntaxException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ChattingPageViewModel(val navigater : ChattingPage) : ViewModel() {

    val userVisible = MutableLiveData<Boolean>()
    val clubVisible = MutableLiveData<Boolean>()
    val chattingList = MutableLiveData<List<ChattingData>>()
    val roomid = navigater.roomId
    val clubImage = navigater.clubImage
    val clubName = navigater.clubName
    val clubId = navigater.clubId
    val index = navigater.index
    val adapter = BaseApi.getInstance()
    val chatBody = MutableLiveData<String>()
    private var readChattingList = mutableListOf<ChattingData>()
    var possingChat = mutableListOf<ChattingData>()
    var roomToken : String = ""
    lateinit var chatInfo :ChattingData
    lateinit var chatting :Array<String>
    val chattingListAdapter = ChattingAdapter(chattingList, this,index,clubName)
    private lateinit var socket : Socket
    var num = 0
    var applyTag = ArrayList<String>()
    init {
        getChatting()
        getRoomToken()
        getApplyTag()
        if(index != 0){
            userVisible.value = false
            clubVisible.value = true
        }
        else{
            userVisible.value = true
            clubVisible.value = false
        }
    }
    fun onCreate(){
        //socket.on("recv_chat",chat)
    }

    @SuppressLint("CheckResult")
    private fun getApplyTag(){
        adapter.clubRecruit(clubId,"Bearer ${accessToken.value}" )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { response ->
                if(response.body()?.major != null){
                    applyTag = response.body()!!.major
                }

            }
    }
    @SuppressLint("CheckResult")
    private fun getChatting() { // 채팅 데이터 가져오기
        adapter.getChatting(roomid,"Bearer ${accessToken.value}" )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ response ->
                if (response.isSuccessful) {
                    println("${response.body()} 이게 채팅 ")
                    response.body()?.let { readChattingList.addAll(it) }
                    possingChat = readChattingList.asReversed()
                    chattingList.value = possingChat
                    chattingListAdapter.notifyDataSetChanged()

                }
            }, {
            })
    }

    @SuppressLint("CheckResult")
    private fun getRoomToken(){ /// 룸 토큰 가져오는 것
        adapter.getRoomToken("Bearer ${accessToken.value}",roomid)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ response ->
                if (response.isSuccessful) {
                    roomToken = response.body()!!.room_token
                    startSocket("${accessToken.value}")
                    joinRoom()

                }
            }, {
            })
    }

    fun joinRoom(){ // 방 입장 소켓
        val data = JSONObject()
        data.put("room_token",roomToken)
        socket.emit("join_room",data)
        socket.on("response",join)
    }


    fun sandChatting(){ // 보내기 버튼 누르면 실행 소켓
        num = 0
        val message = chatBody.value
        println("이게 과연 몇번 출력이 될까?")
        val data = JSONObject()
        data.put("room_token",roomToken)
        data.put("msg",message)
        socket.emit("send_chat",data)
        //socket.on("error",chat)

        chatBody.value = null
    }

    fun helper1(){ // 동아리 지원
        val setPartCallback:(part:String)->Unit={
        if(it.isNotEmpty()){
            val data = JSONObject()
            data.put("room_token",roomToken)
            data.put("major",it)
            socket.emit("helper_apply",data)
        }
    }
        navigater.selectPart(applyTag,setPartCallback)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun helper2(){ // 스케줄
        val setTimeCallback:(Date,String?)->Unit={ date: Date, place: String? ->
            val data = JSONObject()
            data.put("room_token",roomToken)
            data.put("date", date)
            data.put("location",place)
        }
        navigater.selectDate(setTimeCallback)
    }

    fun helper3(){ // 면접 결과 보내는 거 입니다!!!! 이거 club result chat에 버튼에다 ㄱㄱㄱㄱ
        val data = JSONObject()
        data.put("room_token",roomToken)
        data.put("result","boolean 값 넣어야되요!! 면접 합격 면접 불합격")
    }


    fun startSocket(accessToken: String){
        try {
            val opts  = IO.Options()
            opts.transports  = arrayOf(io.socket.engineio.client.transports.WebSocket.NAME) // xhr에러 방지
            socket = IO.socket("https://api.eungyeol.live/chat",opts)
            socket.io().on(Manager.EVENT_TRANSPORT, Emitter.Listener { args ->
                val trans = args[0] as Transport
                trans.on(Transport.EVENT_REQUEST_HEADERS){ // request 해더 넣는 부분
                        args->val mHeaders = args[0] as MutableMap<String, List<String>>
                    println("여기가 실행${accessToken}")
                    mHeaders["Authorization"] = Arrays.asList("Bearer ${accessToken}")
                }
            })
            socket.on(Socket.EVENT_CONNECT) {
                println("성공")
            }.on(Socket.EVENT_CONNECT_ERROR) {
                println("실패;;")
                println(it.contentToString()) // 이게 에러 받는거입니다
            }
            socket.on("response",connect)
            socket.connect()

            socket.on("recv_chat",chat).apply {
                println("가나다라마바사아")
            }
            socket.on("error", connect)
            //socket.on("recv_chat",chat)
        } catch (e: URISyntaxException) {
            println(e.reason)
        }
    }

    val connect : Emitter.Listener =Emitter.Listener{
        val size = it.size-1
        val data  = it
        for(i in 0..size){
            println("${data[i]} 이게 연결 결과값")
        }
    }
    val join : Emitter.Listener =Emitter.Listener{
        val size = it.size-1
        val data  = it
        for(i in 0..size){
            println("${data[i]} 이게 조인 결과값")
        }
    }
    /*val helper1 : Emitter.Listener =Emitter.Listener{
        val size = it.size-1
        val data  = it
        for(i in 0..size){
            println("${data[i]} 이게 helper1 결과값")
        }
    }

    val helper2 : Emitter.Listener =Emitter.Listener{
        val size = it.size-1
        val data  = it
        for(i in 0..size){
            println("${data[i]} 이게 helper2 결과값")
        }
    }
    val helper3 : Emitter.Listener =Emitter.Listener{
        val size = it.size-1
        val data  = it
        for(i in 0..size){
            println("${data[i]} 이게 helper3 결과값")
        }
    }*/

    val chat : Emitter.Listener =Emitter.Listener{

            num++
            val data = it[0].toString()
            println("$data 이거는 데이터입니다")

            chatting = data.split("{\"title\":"  ,",\"msg\":\"" , "\",\"user_type\":\"" , "\",\"date\":\"" , "\"}").toTypedArray()

            println("$chatting asdf")
            for(a : String in chatting){
                println("$a 이게 어떤 값?")
            }
            try {
                val format=SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSz")
                val date=format.parse(chatting[4])
                chatInfo = ChattingData(chatting[1],chatting[2],chatting[3],date)
                possingChat.add(chatInfo)
                chattingList.value = possingChat
                chattingListAdapter.notifyDataSetChanged()
            }catch (e:Throwable){
            }
        }

}