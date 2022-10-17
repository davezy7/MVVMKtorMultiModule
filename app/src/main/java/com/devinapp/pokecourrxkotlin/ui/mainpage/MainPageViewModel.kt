package com.devinapp.pokecourrxkotlin.ui.mainpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.devinapp.pokecourrxkotlin.models.ListDealsModel
import com.devinapp.pokecourrxkotlin.usecase.ListDealsMainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(
    private val useCase: ListDealsMainUseCase
): ViewModel() {

    suspend fun getDealsList(query: HashMap<String, String>): Flow<PagingData<ListDealsModel>> {
        return useCase.getDealsList(query).cachedIn(viewModelScope)
    }
}