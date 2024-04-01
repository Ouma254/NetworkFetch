package com.deknowh.networkfetch.module

import com.deknowh.networkfetch.data.ToDo
import retrofit2.http.GET

interface ApiService {
    @GET("/todos/")
    suspend fun getTodo(): List<ToDo>
}