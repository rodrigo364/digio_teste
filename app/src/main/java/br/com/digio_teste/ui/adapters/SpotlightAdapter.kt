package br.com.digio_teste.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.digio_teste.R
import br.com.digio_teste.models.Spotlight
import br.com.digio_teste.util.Util
import com.bumptech.glide.Glide

class SpotlightAdapter internal constructor(context: Context
): RecyclerView.Adapter<SpotlightAdapter.SpotlightViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var spotlights = emptyList<Spotlight>()

    private lateinit var  mContext: Context

    inner class SpotlightViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
                val itemImage: ImageView = itemView.findViewById(R.id.img_item_spotlight)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotlightViewHolder {
        mContext = parent.context
        val itemView = inflater.inflate(R.layout.adapter_items_spotlights,parent,false)
        return  SpotlightViewHolder(itemView)
    }

    override fun getItemCount() = spotlights.size

    internal fun setSpotlights(spotlights: List<Spotlight>){
        this.spotlights = spotlights
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: SpotlightViewHolder, position: Int) {
       val current = spotlights[position]
        Glide.with(mContext)
            .load(current.bannerURL)
            .error(R.drawable.ic_404_error)
            .placeholder(Util.loadingUtil(mContext))
            .into(holder.itemImage)

        holder.itemImage.contentDescription = current.description
    }
}