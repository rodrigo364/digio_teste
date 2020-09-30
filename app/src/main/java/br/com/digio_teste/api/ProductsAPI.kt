package br.com.digio_teste.api

import br.com.digio_teste.models.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET


interface ProductsAPI {

    @GET("sandbox/products")
    suspend fun getProducts() : Response<ProductsResponse>
}