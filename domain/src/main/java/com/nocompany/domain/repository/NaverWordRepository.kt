package com.nocompany.domain.repository

import com.nocompany.domain.model.Items
import com.nocompany.domain.model.ResultState
import com.nocompany.domain.model.WordItem
import kotlinx.coroutines.flow.Flow

interface NaverWordRepository {
    fun<T> getSearchResult(query : String) : Flow<T>
}