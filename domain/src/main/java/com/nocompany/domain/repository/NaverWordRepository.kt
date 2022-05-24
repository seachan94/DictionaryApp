package com.nocompany.domain.repository

import com.nocompany.domain.model.Items
import com.nocompany.domain.model.ResultState
import kotlinx.coroutines.flow.Flow

interface NaverWordRepository {
    suspend fun getSearchResult(query : String, display : Int,page : Int) : Flow<ResultState<Items>>
}