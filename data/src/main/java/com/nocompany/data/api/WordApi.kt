package com.nocompany.data.api

import com.nocompany.data.model.WordResponse
import com.nocompany.domain.model.ResultState
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WordApi {

    @GET("v1/search/encyc.json")
    suspend fun getWordInfo(
        @Query("query") query : String,
        @Query("display") display : Int,
        @Query("start") page : Int
    ) : ResultState<WordResponse>



}