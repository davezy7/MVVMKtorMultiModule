package com.devinapp.pokecourrxkotlin.services

import com.devinapp.pokecourrxkotlin.models.DealsDetailResponse
import com.devinapp.pokecourrxkotlin.models.ListDealsResponse
import com.devinapp.pokecourrxkotlin.models.NetworkResponse
import com.devinapp.pokecourrxkotlin.models.executeWithResponse
import com.devinapp.pokecourrxkotlin.network.NetworkClient
import io.ktor.client.call.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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

    override suspend fun getDealsDetails(dealId: String) = flow {
        emit(NetworkResponse.Loading)
        try {
            val response = client.get("deals?id=${dealId}")
            val data = response.body<DealsDetailResponse>().toModel()
            emit(NetworkResponse.Success(data))
        } catch (throwable: Throwable) {
            emit(NetworkResponse.Error(throwable))
        }
    }.flowOn(Dispatchers.IO)
}