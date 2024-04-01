package com.deknowh.networkfetch.data


import com.google.gson.annotations.SerializedName

data class ToDo(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_completed")
    val isCompleted: Boolean,
    @SerializedName("title")
    val title: String
)