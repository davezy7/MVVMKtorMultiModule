package com.devinapp.pokecourrxkotlin.models

import android.content.res.Resources
import androidx.paging.PagingSource

val NetworkResponse<*>?.isInitialState get() = this != null && this is NetworkResponse.Success && data == null

val NetworkResponse<*>?.isSucceeded get() = this != null && this is NetworkResponse.Success && data != null

val NetworkResponse<*>?.isError get() = this != null && this is NetworkResponse.Error

val NetworkResponse<*>?.isLoading get() = this != null && this is NetworkResponse.Loading

inline infix fun <T, Value : Any> NetworkResponse<T>?.runSucceeded(predicate: (data: T) -> Value): Value? {
    if (this != null && this.isSucceeded && this is NetworkResponse.Success && this.data != null) {
        return predicate.invoke(this.data)
    }
    return null
}

inline infix fun <T> NetworkResponse<T>.success(predicate: (data: T) -> Unit): NetworkResponse<T> {
    if (this is NetworkResponse.Success && this.data != null) {
        predicate.invoke(this.data)
    }
    return this
}

inline infix fun <T> NetworkResponse<T>.error(predicate: (data: Throwable) -> Unit) {
    if (this is NetworkResponse.Error) {
        predicate.invoke(this.throwable)
    }
}

inline infix fun <T, Value : Any> NetworkResponse<T>.pagingSucceeded(
    predicate: (data: T) -> PagingSource.LoadResult<Int, Value>
): PagingSource.LoadResult<Int, Value> {
    return if (this is NetworkResponse.Success && this.data != null) {
        predicate.invoke(this.data)
    } else {
        if (this is NetworkResponse.Error) {
            PagingSource.LoadResult.Error(this.throwable)
        } else {
            PagingSource.LoadResult.Error(Resources.NotFoundException())
        }
    }
}