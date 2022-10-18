package com.devinapp.pokecourrxkotlin.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.devinapp.pokecourrxkotlin.models.DealsDetailModel
import com.devinapp.pokecourrxkotlin.models.ListDealsModel
import com.devinapp.pokecourrxkotlin.models.NetworkResponse
import com.devinapp.pokecourrxkotlin.paging.DealsPagingSource
import com.devinapp.pokecourrxkotlin.services.GameDealsServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameDealsRepositoryImpl @Inject constructor(
    private val service: GameDealsServices
) : GameDealsRepository {

    override suspend fun getDealsList(query: HashMap<String, String>): Flow<PagingData<ListDealsModel>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { DealsPagingSource(service, query) }
        ).flow
    }

    override suspend fun getDealsDetail(dealsId: String): Flow<NetworkResponse<DealsDetailModel>> {
        return service.getDealsDetails(dealsId)
    }
}