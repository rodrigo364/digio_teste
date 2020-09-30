package br.com.digio_teste.models


import com.google.gson.annotations.SerializedName


data class Cash(
    @SerializedName("bannerURL")
    val bannerURL: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String
)