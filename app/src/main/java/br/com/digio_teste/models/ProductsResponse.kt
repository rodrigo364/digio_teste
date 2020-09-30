package br.com.digio_teste.models


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ProductsResponse(
    @Expose
    @SerializedName("cash")
    val cash: Cash,
    @SerializedName("products")
    val products: List<Product>,
    @SerializedName("spotlight")
    val spotlight: List<Spotlight>
)