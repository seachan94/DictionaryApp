package com.nocompany.data.api

import com.nocompany.data.model.WordResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WordApi {

    @GET("v1/search/encyc.json")
    suspend fun getWordInfo(
        @Query("query") query : String,
        @Query("display") display : Int,
        @Query("start") page : Int
    ) : WordResponse
}