package com.devinapp.pokecourrxkotlin.models

sealed class NetworkResponse<out R> {
    data class Success<out T>(val data: T): NetworkResponse<T>()
    data class Error(val throwable: Throwable): NetworkResponse<Nothing>()
    object Loading: NetworkResponse<Nothing>()
}

inline fun <T> executeWithResponse(body: () -> T): NetworkResponse<T> {
    return try {
        NetworkResponse.Success(body.invoke())
    } catch (throwable: Throwable) {
        throwable.printStackTrace()
        NetworkResponse.Error(throwable)
    }
}