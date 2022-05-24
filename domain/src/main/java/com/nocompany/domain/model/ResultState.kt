package com.nocompany.domain.model

sealed class ResultState<out T> {

    object Loading : ResultState<Nothing>()
    data class Success<T>(val data : T):ResultState<T>()
    data class Error<T>(val throwable: Throwable? = null) : ResultState<T>()

}