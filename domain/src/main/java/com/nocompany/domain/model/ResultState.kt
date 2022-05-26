package com.nocompany.domain.model

import java.io.IOException

sealed class ResultState<out T> {

    object Loading : ResultState<Nothing>()
    data class Success<T>(val data : T):ResultState<T>()
    data class Error<T>(val throwable: Throwable? = null) : ResultState<T>()
    data class ApiError<T>(val code : Int,val message : String) : ResultState<T>()
    data class NetworkError<T>(val error : Throwable) : ResultState<T>()
}