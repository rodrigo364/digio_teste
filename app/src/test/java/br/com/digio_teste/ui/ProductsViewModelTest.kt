package br.com.digio_teste.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.Test

class ProductsViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var productsViewModel: ProductsViewModel

    @Test
    fun `when view model getProducts get success then sets productsLiveData`(){

    }
}

