package com.devinapp.pokecourrxkotlin.ui.mainpage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.devinapp.pokecourrxkotlin.databinding.ItemMainPageBinding
import com.devinapp.pokecourrxkotlin.models.ListDealsModel
import com.devinapp.pokecourrxkotlin.utils.extensions.toUSD

class MainPageAdapter: PagingDataAdapter<ListDealsModel, MainPageAdapter.MainPageAdapterViewHolder>(COMPARATOR) {

    private var onItemClickListener: ((data: ListDealsModel) -> Unit)? = null

    override fun onBindViewHolder(holder: MainPageAdapterViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPageAdapterViewHolder {
        return MainPageAdapterViewHolder(
            ItemMainPageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setOnItemClickListener(listener: (data: ListDealsModel) -> Unit) {
        this.onItemClickListener = listener
    }

    inner class MainPageAdapterViewHolder(
        private val binding: ItemMainPageBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ListDealsModel) {
            binding.apply {
                tvItemMainTitle.text = data.title
                ivItemMain.load(data.thumb)
                tvItemMainOriginalPrice.text = data.normalPrice.toUSD()
                tvItemMainSalePrice.text = data.salePrice.toUSD()
                mcvMainPageItem.setOnClickListener {
                    onItemClickListener?.invoke(data)
                }
            }
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<ListDealsModel>() {
            override fun areItemsTheSame(
                oldItem: ListDealsModel,
                newItem: ListDealsModel
            ): Boolean {
                return oldItem.dealID == newItem.dealID
            }

            override fun areContentsTheSame(
                oldItem: ListDealsModel,
                newItem: ListDealsModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}