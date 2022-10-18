package com.devinapp.pokecourrxkotlin.ui

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.devinapp.pokecourrxkotlin.R
import com.devinapp.pokecourrxkotlin.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavController()
        setupToolbar()
    }

    fun setToolbar(@StringRes title: Int, subTitle: String = "") {
        binding.topAppBar.apply {
            setTitle(title)
            this.subtitle = subTitle
        }
    }

    private fun setupNavController() {
        val navHostFragment: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container_main) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.topAppBar, navController)
    }

    private fun setupToolbar() {
        lifecycleScope.launchWhenResumed {
            navController.addOnDestinationChangedListener { _, destination, _ ->
                when(destination.id) {
                    R.id.mainPageFragment -> {
                        setToolbar(R.string.main_page_topbar_title)
                    }
                }
            }
        }
    }
}