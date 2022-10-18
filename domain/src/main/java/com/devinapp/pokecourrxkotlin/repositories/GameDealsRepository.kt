package com.devinapp.pokecourrxkotlin.repositories

import androidx.paging.PagingData
import com.devinapp.pokecourrxkotlin.models.DealsDetailModel
import com.devinapp.pokecourrxkotlin.models.ListDealsModel
import com.devinapp.pokecourrxkotlin.models.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface GameDealsRepository {

    suspend fun getDealsList(query: HashMap<String, String>): Flow<PagingData<ListDealsModel>>
    suspend fun getDealsDetail(dealsId: String): Flow<NetworkResponse<DealsDetailModel>>
}