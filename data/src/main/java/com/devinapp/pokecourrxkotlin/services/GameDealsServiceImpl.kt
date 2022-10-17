package com.devinapp.pokecourrxkotlin.services

import com.devinapp.pokecourrxkotlin.models.ListDealsResponse
import com.devinapp.pokecourrxkotlin.network.NetworkClient
import com.devinapp.pokecourrxkotlin.network.NetworkResponse
import com.devinapp.pokecourrxkotlin.network.executeWithResponse
import io.ktor.client.call.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameDealsServiceImpl @Inject constructor(
    private val client: NetworkClient
): GameDealsServices {

    override suspend fun getDealsList(pageNumber: Int, query: HashMap<String, String>): NetworkResponse<ArrayList<ListDealsResponse>> {
        return withContext(Dispatchers.IO) {
            executeWithResponse {
                client.get(endpoint = "deals?pageNumber=$pageNumber&pageSize=10", query = query)
                    .body()
            }
        }
    }

    override suspend fun getDealsDetails(dealId: String) {
        TODO("Not yet implemented")
    }
}