package br.com.digio_teste.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.digio_teste.R
import br.com.digio_teste.models.Product
import com.bumptech.glide.Glide


class ProductAdapter internal constructor(
    context: Context): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var products = emptyList<Product>()
    private lateinit var  mContext: Context

    inner class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemText: ImageView = itemView.findViewById(R.id.img_item_product)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        mContext = parent.context
        val itemView = inflater.inflate(R.layout.adapter_items_products,parent,false)
        return ProductViewHolder(itemView)
    }

    internal fun setProducts(products: List<Product>){
        this.products = products
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val current = products[position]
        Glide.with(mContext)
            .load(current.imageURL)
            .error(R.drawable.ic_launcher_background)
            .into(holder.itemText)


    }

}