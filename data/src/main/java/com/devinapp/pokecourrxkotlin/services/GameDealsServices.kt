package com.devinapp.pokecourrxkotlin.services

import com.devinapp.pokecourrxkotlin.models.ListDealsResponse
import com.devinapp.pokecourrxkotlin.network.NetworkResponse

interface GameDealsServices {
    suspend fun getDealsList(pageNumber: Int, query: HashMap<String, String>): NetworkResponse<ArrayList<ListDealsResponse>>
    suspend fun getDealsDetails(dealId: String)
}