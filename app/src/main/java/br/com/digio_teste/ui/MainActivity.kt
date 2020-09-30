package br.com.digio_teste.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.digio_teste.R
import br.com.digio_teste.models.Cash
import br.com.digio_teste.repository.ProductsRepository
import br.com.digio_teste.ui.adapters.ProductAdapter
import br.com.digio_teste.ui.adapters.SpotlightAdapter
import br.com.digio_teste.util.Resource
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_cash.*
import kotlinx.android.synthetic.main.products_content.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductsViewModel
    private lateinit var adapterSpotlight: SpotlightAdapter
    private lateinit var adapterProduct: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        setupViewModel()
        observe()

    }

    private fun setupRecyclerView(){

        val layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL, false)

        adapterSpotlight = SpotlightAdapter(this)
        adapterProduct = ProductAdapter(this)

        recyclerview_spotilife.adapter = adapterSpotlight
        recyclerview_product.adapter = adapterProduct

        recyclerview_spotilife.layoutManager = layoutManager
        recyclerview_product.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupCash(cash: Cash){
        Glide.with(this).load(cash.bannerURL).into(img_cash)
    }

    private fun setupViewModel(){

        viewModel = ViewModelProvider(
            this,
            ProductsViewModelProviderFactory(ProductsRepository())
        ).get(ProductsViewModel::class.java)
        viewModel.getProducts()
    }

    private fun observe(){
        viewModel.products.observe(this, Observer {response ->
            when(response){
                is Resource.Success -> {
                    viewFlipper.displayedChild = Flipper.SUCCESS
                         response.data?.let { products->
                         adapterSpotlight.setSpotlights(products.spotlight)
                         adapterProduct.setProducts(products.products)
                         setupCash(products.cash)

                    }
                }
                is Resource.Error ->{
                    viewFlipper.displayedChild = Flipper.ERROR
                }
                is Resource.Loading -> {
                    viewFlipper.displayedChild = Flipper.LOADING
                }
            }
        })

        viewModel.getProducts()
    }

    private object Flipper {
        const val LOADING = 0
        const val SUCCESS = 1
        const val ERROR = 2
    }
}