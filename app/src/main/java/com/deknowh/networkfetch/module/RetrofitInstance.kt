package com.deknowh.networkfetch.module

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // api baseurl
    private const val BASE_URL = "https://kuiprep.onrender.com/"
    // retrofit instance
    val api: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
             retrofit.create(ApiService::class.java)
    }
}