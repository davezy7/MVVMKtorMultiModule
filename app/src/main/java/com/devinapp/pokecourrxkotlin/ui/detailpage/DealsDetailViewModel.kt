package com.devinapp.pokecourrxkotlin.ui.detailpage

import android.net.Network
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devinapp.pokecourrxkotlin.models.DealsDetailModel
import com.devinapp.pokecourrxkotlin.models.NetworkResponse
import com.devinapp.pokecourrxkotlin.usecase.ListDealsMainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DealsDetailViewModel @Inject constructor(
    private val useCase: ListDealsMainUseCase
) : ViewModel() {

    private val _dealsDetailState: MutableStateFlow<NetworkResponse<DealsDetailModel?>> =
        MutableStateFlow(NetworkResponse.Success(null))
    val dealsDetailState = _dealsDetailState.asStateFlow()

    suspend fun getDealsDetail(dealId: String) {
        useCase.getDealsDetail(dealId)
            .onEach {
                _dealsDetailState.value = it
            }
            .launchIn(viewModelScope)
    }
}