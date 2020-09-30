package br.com.digio_teste.models


import com.google.gson.annotations.SerializedName


data class Spotlight(
    @SerializedName("bannerURL")
    val bannerURL: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String
)