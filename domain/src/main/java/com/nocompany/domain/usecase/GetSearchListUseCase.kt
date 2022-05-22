package com.nocompany.domain.usecase

import com.nocompany.domain.repository.NaverWordRepository
import javax.inject.Inject

class GetSearchListUseCase @Inject constructor(
    private val naverWordRepository: NaverWordRepository
) {
    suspend operator fun invoke(query : String, display : Int ,page : Int) =
        naverWordRepository.getSearchResult(query,display,page)
}