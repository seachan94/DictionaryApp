package com.nocompany.domain.model

sealed class NetworkResult<out T> {

    object Loading : NetworkResult<Nothing>()
    data class Success<T>(val data : T):NetworkResult<T>()
    data class Error<T>(val throwable: Throwable? = null) : NetworkResult<T>()

}