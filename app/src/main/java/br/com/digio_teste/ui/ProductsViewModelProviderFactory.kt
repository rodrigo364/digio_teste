package br.com.digio_teste.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.digio_teste.repository.ProductsRepository

class ProductsViewModelProviderFactory(
    private val productsRepository: ProductsRepository
) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      return ProductsViewModel(productsRepository) as T
    }
}