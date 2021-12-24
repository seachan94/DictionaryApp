package com.example.dictionaryapp.data.remote.repository

import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {


    @GET("api/v2/entries/ko/{word}")
    suspend fun searchWordInfo(
        @Path("word") word : String
    ) : List<WordInfo>

    @GET("api/v2/entries/en/{word}")
    suspend fun searchWordInfoEn(
        @Path("word") word : String
    ) : List<WordInfo>

}