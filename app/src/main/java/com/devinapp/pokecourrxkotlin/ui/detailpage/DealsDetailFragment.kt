package com.devinapp.pokecourrxkotlin.ui.detailpage

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.devinapp.pokecourrxkotlin.R
import com.devinapp.pokecourrxkotlin.databinding.FragmentDealsDetailBinding
import com.devinapp.pokecourrxkotlin.models.isError
import com.devinapp.pokecourrxkotlin.models.isLoading
import com.devinapp.pokecourrxkotlin.models.isSucceeded
import com.devinapp.pokecourrxkotlin.models.success
import com.devinapp.pokecourrxkotlin.ui.MainActivity
import com.devinapp.pokecourrxkotlin.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DealsDetailFragment : BaseFragment<FragmentDealsDetailBinding>() {

    private val viewModel: DealsDetailViewModel by viewModels()
    private val args: DealsDetailFragmentArgs by navArgs()

    override fun setLayout(inflater: LayoutInflater) = FragmentDealsDetailBinding
        .inflate(inflater)

    override fun onFragmentCreated() {
        lifecycleScope.launch { viewModel.getDealsDetail(args.dealsId) }
        setupCollector()
    }

    private fun setupCollector() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.dealsDetailState.collect { state ->
                    when {
                        state.isLoading -> {

                        }
                        state.isSucceeded -> {
                            state.success {
                                binding.tvDealsDetailTitle.text = it?.gameInfo?.name
                                (activity as MainActivity).setToolbar(
                                    R.string.main_page_topbar_title,
                                    it?.gameInfo?.name.toString()
                                )
                            }
                        }
                        state.isError -> {

                        }
                    }
                }
            }
        }
    }
}