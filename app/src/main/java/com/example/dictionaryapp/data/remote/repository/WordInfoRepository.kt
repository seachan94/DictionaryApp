package com.example.dictionaryapp.data.remote.repository


import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo
import com.example.dictionaryapp.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

interface WordInfoRepository {

    fun getSearchWord(word : String) : Flow<Resource<List<WordInfo>>>


}