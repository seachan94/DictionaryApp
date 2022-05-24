package com.nocompany.data.repository

import com.nocompany.data.api.WordApi
import com.nocompany.data.mapper.WordEntityMapper
import com.nocompany.domain.model.ResultState
import com.nocompany.domain.model.WordItem
import com.nocompany.domain.repository.NaverWordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
class NaverWordRepositoryImpl @Inject constructor(
    private val wordApi : WordApi
): NaverWordRepository {
    override suspend fun getSearchResult(
        query: String,
        display: Int,
        page: Int,
    ): Flow<ResultState<WordItem>> = flow{
        emit(ResultState.Loading)
        val response = wordApi.getWordInfo(query,display,page)
        emit(ResultState.Success(WordEntityMapper.mapperToWordItem(response)))
    }.catch { e->
        emit(ResultState.Error(e))
    }



}