package com.semicolon.ddyzd_android.viewmodel


import android.annotation.SuppressLint
import android.widget.ArrayAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.semicolon.ddyzd_android.BaseApi
import com.semicolon.ddyzd_android.R
import com.semicolon.ddyzd_android.adapter.ChatListAdapter
import com.semicolon.ddyzd_android.model.ChatListData
import com.semicolon.ddyzd_android.model.RoomData
import com.semicolon.ddyzd_android.ul.activity.ChatList
import com.semicolon.ddyzd_android.viewmodel.MainViewModel.Companion.accessToken
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.socket.client.IO
import io.socket.client.Manager
import io.socket.client.Socket
import io.socket.emitter.Emitter
import io.socket.engineio.client.Transport
import java.net.URISyntaxException
import java.util.*
import kotlin.collections.ArrayList

class ChatListViewModel(val navigater: ChatList) : ViewModel() {
    private val apiAdapter = BaseApi.getInstance()
    private var readChatList = mutableListOf<RoomData>()
    val allList = MutableLiveData<ChatListData>()

    val list = MutableLiveData<List<RoomData>>()
    val clubListAdapter = ChatListAdapter(list, this)
    val value = listOf<String>()

    private var initList = arrayListOf("")
    var section = MutableLiveData<ArrayList<String>>(initList)

    var spinnerAdapter = MutableLiveData<ArrayAdapter<String>>(
        ArrayAdapter(
            navigater, R.layout.support_simple_spinner_dropdown_item,
            section.value!!
        )
    )
    val index = MutableLiveData<Int>(0)
    lateinit var socket: Socket

    fun onDestroy() {
        //socket.disconnect()
    }

    fun onCreate() {
        allList.postValue(null)
        section.postValue(null)
        readChatList.clear()
        list.postValue(null)
        callChatList(navigater)
    }


    @SuppressLint("CheckResult")
    fun callChatList(navigater: ChatList) {
        apiAdapter.chatList("Bearer ${accessToken.value}")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                if (response.isSuccessful) {
                    // 이 부분이 어뎁터
                    if (response.body() != null) {
                        startSocket("${accessToken.value}")
                        allList.value = response.body()
                        section.value = allList.value!!.club_section
                        spinnerAdapter.value = (ArrayAdapter(
                            navigater, R.layout.support_simple_spinner_dropdown_item,
                            section.value!!
                        ))

                        for (i in 0 until (allList.value?.rooms?.size ?: 0)) {
                            when (response.body()!!.rooms[i].index) {
                                0 -> {
                                    readChatList.add(response.body()!!.rooms[i])
                                }
                            }
                        }
                        list.value = readChatList as ArrayList<RoomData>
                        clubListAdapter.notifyDataSetChanged()

                    }

                } else {
                    navigater.startLogin()
                }
            }, { throwable ->
                println("${throwable.message}")
            })
    }

    fun selectPeople() {
        if (allList.value != null) {
            readChatList.clear()

            var rotate=allList.value?.rooms?.size ?: 1
            for (i in 0 until (--rotate)) {
                if (allList.value!!.rooms[i].index == index.value) {
                    readChatList.add(allList.value!!.rooms[i])
                }
            }
            list.value=readChatList
            clubListAdapter.notifyDataSetChanged()
        }
    }
    fun goChatting(data: RoomData) {
        navigater.startChating(data)
    }

    //소켓 부분
    fun startSocket(accessToken: String) {
        try {
            val opts = IO.Options()
            opts.transports =
                arrayOf(io.socket.engineio.client.transports.WebSocket.NAME) // xhr에러 방지
            socket = IO.socket("https://api.eungyeol.live/chat", opts)
            socket.io().on(Manager.EVENT_TRANSPORT, Emitter.Listener { args ->
                val trans = args[0] as Transport
                trans.on(Transport.EVENT_REQUEST_HEADERS) { // request 해더 넣는 부분
                        args ->
                    val mHeaders = args[0] as MutableMap<String, List<String>>
                    println("여기가 실행${accessToken}")
                    mHeaders["Authorization"] = Arrays.asList("Bearer ${accessToken}")
                }
            })

            socket.on(Socket.EVENT_CONNECT) {
                println("성공")
            }.on(Socket.EVENT_CONNECT_ERROR) {
                println("실패;;")
                println(it.contentToString())
            }
            socket.on("response", event)
            socket.on("alarm", alarm)
            socket.connect()
        } catch (e: URISyntaxException) {
            println(e.reason)
        }
    }

    val event: Emitter.Listener = Emitter.Listener {
        val size = it.size - 1
        val data = it
        for (i in 0..size) {
            println("${data[i]} 이게 결과값1")
        }
    }
    val alarm: Emitter.Listener = Emitter.Listener {
        val size = it.size - 1
        val data = it
        for (i in 0..size) {
            println("${data[i]} 이게 결과값1")
        }
        callChatList(navigater)
    }
    fun onBackClicked() {
        navigater.finish()
    }
}
