package br.com.digio_teste.repository

import br.com.digio_teste.api.RetrofitInstance

class ProductsRepository {

    suspend fun getProducts() = RetrofitInstance.api.getProducts()
}