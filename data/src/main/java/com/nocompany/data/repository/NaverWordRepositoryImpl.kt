package com.nocompany.data.repository

import android.app.usage.NetworkStats
import android.net.Network
import com.nocompany.data.api.WordApi
import com.nocompany.data.mapper.WordEntityMapper
import com.nocompany.domain.model.NetworkResult
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
    ): Flow<NetworkResult<List<WordItem>>> = flow{

        emit(NetworkResult.Loading)
        val response = wordApi.getWordInfo(query,10,1)
        emit(NetworkResult.Success(WordEntityMapper.mapperToWordItem(response)))

    }.catch { e->

        emit(NetworkResult.Error(e))
    }.flowOn(Dispatchers.IO)

}