package com.devinapp.pokecourrxkotlin.di

import com.devinapp.pokecourrxkotlin.repositories.GameDealsRepository
import com.devinapp.pokecourrxkotlin.repositories.GameDealsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModules {

    @Binds
    fun bindGameDealsRepository(repository: GameDealsRepositoryImpl): GameDealsRepository

}