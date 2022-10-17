package com.devinapp.pokecourrxkotlin.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devinapp.pokecourrxkotlin.databinding.ViewCommonLoadStateBinding

class CommonLoadStateAdapter(
    private val retry: () -> Unit
): LoadStateAdapter<CommonLoadStateAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder {
        return ViewHolder(
            ViewCommonLoadStateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class ViewHolder(
        private val binding: ViewCommonLoadStateBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(loadState: LoadState) {
            binding.apply {
                if (loadState is LoadState.Error) {
                    tvCommonLoadStateMessage.text = loadState.error.message
                }

                cpiCommonLoadState.isVisible = loadState is LoadState.Loading
                tvCommonLoadStateMessage.isVisible = loadState is LoadState.Error
                btnCommonLoadStateButton.isVisible = loadState is LoadState.Error

                btnCommonLoadStateButton.setOnClickListener { retry.invoke() }
            }
        }
    }
}