package com.example.dictionaryapp.util


sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    data class Success<T>(val data: T?) : Resource<T>()
    data class Error<T>(val message: String) : Resource<T>()
}
