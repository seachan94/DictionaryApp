package com.example.dictionaryapp.data.remote.repository

import com.example.dictionaryapp.data.remote.Word
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DictionaryApi {

    @GET("search.do")
    suspend fun searchWordInfo(
        @Query("key") key : String,
        @Query("req_type") type : String,
        @Query("q") searchValue : String
    ) : Word
}