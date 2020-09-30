package br.com.digio_teste.models


import com.google.gson.annotations.SerializedName


data class Product(

    @SerializedName("description")
    val description: String,
    @SerializedName("imageURL")
    val imageURL: String,
    @SerializedName("name")
    val name: String
)