package com.devinapp.pokecourrxkotlin.services

import com.devinapp.pokecourrxkotlin.models.DealsDetailModel
import com.devinapp.pokecourrxkotlin.models.DealsDetailResponse
import com.devinapp.pokecourrxkotlin.models.ListDealsResponse
import com.devinapp.pokecourrxkotlin.models.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface GameDealsServices {
    suspend fun getDealsList(pageNumber: Int, query: HashMap<String, String>): NetworkResponse<ArrayList<ListDealsResponse>>
    suspend fun getDealsDetails(dealId: String): Flow<NetworkResponse<DealsDetailModel>>
}