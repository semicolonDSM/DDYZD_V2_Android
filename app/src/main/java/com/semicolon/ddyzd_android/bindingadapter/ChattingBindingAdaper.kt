package com.semicolon.ddyzd_android.bindingadapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.semicolon.ddyzd_android.R
import com.semicolon.ddyzd_android.adapter.ChattingAdapter
import com.semicolon.ddyzd_android.viewmodel.ChatListViewModel
import java.text.SimpleDateFormat
import java.util.*

object ChattingBindingAdaper {
    @JvmStatic
    @BindingAdapter("verChattingAdapter")
    fun chattingListAdapter(recyclerView: RecyclerView, adapter: ChattingAdapter) {
        val layoutManager =
            LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
        layoutManager.orientation = RecyclerView.VERTICAL
        layoutManager.stackFromEnd = true
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("chattingImageUrl")
    fun loadImage(imageView: ImageView, url: String?) {
        if (url != null) {
            Glide.with(imageView.context)
                .load("https://api.semicolon.live/file/$url")
                .error(R.drawable.group).into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("spinner_adapter")
    fun spinnerAdapter(spinner: Spinner, adapter: SpinnerAdapter?) {
        spinner.adapter = adapter
    }

    @SuppressLint("ClickableViewAccessibility")
    @JvmStatic
    @BindingAdapter("spinner_select")
    fun spinnerSelect(spinner: Spinner, viewModel: ChatListViewModel) {
        var userSelect = false
        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    userSelect = false
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (userSelect) {
                        viewModel.index.value = position
                        viewModel.selectPeople()
                        userSelect = false
                    }

                }

            }
        spinner.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    userSelect = true
                }
            }
            false
        }
    }

    @JvmStatic
    @BindingAdapter("string_time_adapter")
    fun timeAdapter(textView: TextView, time: String?) {
        if (time != null) {
            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSz")
            val date = format.parse(time)
            val currentTime = format.format(date!!)
            val getTime = format.format(time)
            val longCurrentTime = format.parse(currentTime).time
            val longGetTime = format.parse(getTime).time
            val diff = (longCurrentTime - longGetTime) / 1000
            val dayDiff = (diff / 86400)
            if (dayDiff < 0 || dayDiff >= 31) {
                val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA)
                textView.text = dateFormat.format(time)
            } else {
                if (dayDiff <= 0) {
                    when (diff) {
                        in 0..60 ->
                            textView.text = "방금"
                        in 61..120 -> textView.text = "1분전"
                        in 121..3600 ->
                            textView.text = "${diff / 60}분 전"
                        in 3601..7200 -> textView.text = "1시간 전"
                        else -> textView.text = "${diff / 3600}시간 전"
                    }
                } else {
                    when (dayDiff) {
                        1.toLong() -> textView.text = "어제"
                        in 2..6 -> textView.text = "${dayDiff}일 전"
                        else -> textView.text = "${dayDiff / 7}주 전"
                    }
                }
            }
        }

    }

}