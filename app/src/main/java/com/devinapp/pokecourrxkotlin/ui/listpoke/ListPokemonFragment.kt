package com.devinapp.pokecourrxkotlin.ui.listpoke

import android.view.LayoutInflater
import com.devinapp.pokecourrxkotlin.databinding.FragmentListPokemonBinding
import com.devinapp.pokecourrxkotlin.ui.base.BaseFragment

class ListPokemonFragment : BaseFragment<FragmentListPokemonBinding>() {

    override fun setLayout(inflater: LayoutInflater) = FragmentListPokemonBinding
        .inflate(inflater)

    override fun onFragmentCreated() {

    }

}