package com.devinapp.pokecourrxkotlin.ui.mainpage

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.devinapp.pokecourrxkotlin.databinding.FragmentMainPageBinding
import com.devinapp.pokecourrxkotlin.ui.base.BaseFragment
import com.devinapp.pokecourrxkotlin.ui.base.CommonLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainPageFragment : BaseFragment<FragmentMainPageBinding>() {

    private val viewModel: MainPageViewModel by viewModels()
    private var mainPageAdapter = MainPageAdapter()

    override fun setLayout(inflater: LayoutInflater) = FragmentMainPageBinding
        .inflate(inflater)

    override fun onFragmentCreated() {
        setupCollector()
        setupRecyclerView()
        setupAdapter()
    }

    private fun setupCollector() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.getDealsList(hashMapOf()).collectLatest {
                    mainPageAdapter.submitData(it)
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvMainPage.adapter = mainPageAdapter.withLoadStateFooter(
            footer = CommonLoadStateAdapter { mainPageAdapter.retry() }
        )
    }

    private fun setupAdapter() {
        mainPageAdapter.setOnItemClickListener { data ->
            val action = MainPageFragmentDirections
                .actionMainPageFragmentToDealsDetailFragment(data.dealID)
            findNavController().navigate(action)
        }
    }
}