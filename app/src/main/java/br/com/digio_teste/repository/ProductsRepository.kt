package br.com.digio_teste.repository

import br.com.digio_teste.api.RetrofitInstance
import br.com.digio_teste.models.ProductsResponse
import retrofit2.Response

interface ProductsRepository {

    suspend fun getProducts() : Response<ProductsResponse>
}