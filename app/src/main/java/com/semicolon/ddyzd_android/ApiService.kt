package com.semicolon.ddyzd_android

import com.semicolon.ddyzd_android.model.ClubData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.Query

interface ApiService {
    @GET("club/list")
    fun clublist(
    ): Call<ArrayList<ClubData>>

}