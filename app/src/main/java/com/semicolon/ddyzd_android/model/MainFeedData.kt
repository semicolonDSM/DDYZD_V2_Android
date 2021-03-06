package com.semicolon.ddyzd_android.model

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class MainFeedData(
    @SerializedName("feedId") val feedId:String,
    @SerializedName("clubName")val clubName:String,
    @SerializedName("clubId")val clubId:Int,
    @SerializedName("profileImage")val profileImage:String,
    @SerializedName("uploadAt")val uploadAt: Date,
    @SerializedName("content")val content:String,
    @SerializedName("media")val media:ArrayList<String>,
    @SerializedName("owner")val owner:Boolean,
    @SerializedName("flags") var flags:Int,
    @SerializedName("flag") var flag:Boolean,
    @SerializedName("follow")val follow:Boolean
)