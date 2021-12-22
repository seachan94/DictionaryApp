package com.example.dictionaryapp.data.remote.repository

import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    @GET("api/v2/entries/ko/{word}")
    suspend fun getWordInfo(
        @Path("word") word : String
    ) : List<WordInfo>

    @GET("api/v2/entries/ko/{word}")
    suspend fun searchWordInfoApi(
        @Path("word") word : String
    ) : List<WordInfo>


    companion object{
        const val BASE_URL = "https://api.dictionaryapi.dev/"
    }
}