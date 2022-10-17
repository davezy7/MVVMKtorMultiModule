package com.devinapp.pokecourrxkotlin.repositories

import androidx.paging.PagingData
import com.devinapp.pokecourrxkotlin.models.ListDealsModel
import kotlinx.coroutines.flow.Flow

interface GameDealsRepository {

    suspend fun getDealsList(query: HashMap<String, String>): Flow<PagingData<ListDealsModel>>
}