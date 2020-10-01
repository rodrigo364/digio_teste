package br.com.digio_teste.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digio_teste.models.ProductsResponse
import br.com.digio_teste.repository.ProductsApiDataSource
import br.com.digio_teste.repository.ProductsRepository
import br.com.digio_teste.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class ProductsViewModel(
    private val productsRepository: ProductsApiDataSource
) : ViewModel(){

    val products: MutableLiveData<Resource<ProductsResponse>> = MutableLiveData()

    fun getProducts() = viewModelScope.launch {
        products.postValue(Resource.Loading())
        val response = productsRepository.getProducts()
         products.postValue(handleProductsResponse(response))
    }

    private fun handleProductsResponse(response:Response<ProductsResponse>) : Resource<ProductsResponse>{
        if(response.isSuccessful){
            response.body()?.let {resultProducts ->
                return Resource.Success(resultProducts)
            }
        }
        return Resource.Error(response.message())
    }

}