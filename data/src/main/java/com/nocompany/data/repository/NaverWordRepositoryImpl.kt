package com.nocompany.data.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nocompany.data.api.WordApi
import com.nocompany.data.datasource.paging.NaverWordPagingSource
import com.nocompany.data.mapper.WordMapper
import com.nocompany.data.model.Item
import com.nocompany.data.model.WordResponse
import com.nocompany.domain.model.Items
import com.nocompany.domain.model.ResultState
import com.nocompany.domain.model.WordItem
import com.nocompany.domain.repository.NaverWordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
class NaverWordRepositoryImpl @Inject constructor(
    private val wordApi : WordApi
): NaverWordRepository {
    override fun<T> getSearchResult(query: String, ): Flow<T> {
        return Pager(
            config = PagingConfig(
                pageSize = NaverWordPagingSource.DEFAULT_SIZE,
                initialLoadSize = NaverWordPagingSource.DEFAULT_SIZE),
            pagingSourceFactory = {
                NaverWordPagingSource(wordApi, query)
            }
        ).flow as Flow<T>
    }




}