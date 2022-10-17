package com.devinapp.pokecourrxkotlin.usecase

import androidx.paging.PagingData
import com.devinapp.pokecourrxkotlin.models.ListDealsModel
import com.devinapp.pokecourrxkotlin.repositories.GameDealsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ListDealsMainUseCaseImpl @Inject constructor(
    private val repository: GameDealsRepository
): ListDealsMainUseCase {

    override suspend fun getDealsList(query: HashMap<String, String>): Flow<PagingData<ListDealsModel>> {
        return repository.getDealsList(query)
    }
}