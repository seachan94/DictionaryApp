package com.nocompany.domain.usecase

import android.util.Log
import com.nocompany.domain.model.ResultState
import com.nocompany.domain.model.WordItem
import com.nocompany.domain.repository.NaverWordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchListUseCase @Inject constructor(
    private val naverWordRepository: NaverWordRepository
) {
    operator fun<T> invoke(query : String) : Flow<T> =
        naverWordRepository.getSearchResult(query)
}