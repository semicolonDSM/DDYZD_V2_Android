package com.semicolon.ddyzd_android.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.semicolon.ddyzd_android.BaseApi
import com.semicolon.ddyzd_android.adapter.MainFeedAdapter
import com.semicolon.ddyzd_android.model.MainFeedData
import com.semicolon.ddyzd_android.ul.activity.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainFeedViewModel(private val navigator: MainActivity) : ViewModel() {
    var readFeed = ArrayList<MainFeedData>()
    val feeds = MutableLiveData<List<MainFeedData>>()
    val feedAdapter = MainFeedAdapter(feeds, this)
    val callApi = MutableLiveData<Int>(0)
    val adapter = BaseApi.getInstance()

    fun onCreate() {
        readFeed.clear()
        readFeeds()
        feedAdapter.notifyDataSetChanged()
    }

    fun readFeeds() {
        adapter.readFeed(callApi.value.toString()).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {
                println("error")
            }
            .unsubscribeOn(Schedulers.io())
            .subscribe() { result ->
                readFeed.addAll(result)
                feeds.value = readFeed
            }
    }

    fun onChattingClicked() {
        navigator.startChatting()
    }
}