package br.com.digio_teste.repository

import br.com.digio_teste.api.RetrofitInstance

class ProductsApiDataSource : ProductsRepository {
    override suspend fun getProducts() =  RetrofitInstance.api.getProducts()
}