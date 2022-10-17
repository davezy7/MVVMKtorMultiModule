package com.devinapp.pokecourrxkotlin.di

import com.devinapp.pokecourrxkotlin.usecase.ListDealsMainUseCase
import com.devinapp.pokecourrxkotlin.usecase.ListDealsMainUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModules {

    @Binds
    fun bindListDealsMainUseCase(useCase: ListDealsMainUseCaseImpl): ListDealsMainUseCase

}