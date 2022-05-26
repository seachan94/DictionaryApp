package com.nocompany.data.datasource.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nocompany.data.api.WordApi
import com.nocompany.data.mapper.WordMapper
import com.nocompany.data.model.WordResponse
import com.nocompany.domain.model.Items
import com.nocompany.domain.model.ResultState
import com.nocompany.domain.model.WordItem
import java.lang.Exception

class NaverWordPagingSource(
    private val wordApi: WordApi,
    private val searchTxt: String,
) : PagingSource<Int, Items>() {
    override fun getRefreshKey(state: PagingState<Int, Items>) =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }


    override suspend fun load(params: LoadParams<Int>) : LoadResult<Int, Items>  =
        try {
            val position = params.key ?: 1
            val start = if(position == 1 ) 1 else ((position-1) * DEFAULT_SIZE)+1

            val response = wordApi.getWordInfo(searchTxt, params.loadSize, start)

            val result = if (response is ResultState.Success) {

                val isLastPage = position * DEFAULT_SIZE >= response.data.total
                val data = WordMapper.toWordItems(response.data)
                LoadResult.Page(
                    data = data.items,
                    prevKey = if (position == 1) null else position - 1,
                    nextKey = if(isLastPage) null else position+1
                )
            } else {
                LoadResult.Error(Exception())
            }
            result
        } catch (e: Exception) {
            LoadResult.Error(Exception())
        }



    companion object {
        const val DEFAULT_SIZE = 50
    }
}