package com.devinapp.pokecourrxkotlin.di

import android.content.Context
import com.devinapp.pokecourrxkotlin.network.NetworkClient
import com.devinapp.pokecourrxkotlin.services.GameDealsServiceImpl
import com.devinapp.pokecourrxkotlin.services.GameDealsServices
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModules {

    @Provides
    @Singleton
    fun provideNetworkClient(): NetworkClient {
        return NetworkClient()
    }

    @Provides
    @Singleton
    fun provideService(client: NetworkClient): GameDealsServices {
        return GameDealsServiceImpl(client)
    }
}