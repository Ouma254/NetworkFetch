package com.deknowh.networkfetch.data


import com.google.gson.annotations.SerializedName

data class MyData(
    @SerializedName("family")
    val family: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("fullName")
    val fullName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("title")
    val title: String
)