package com.example.dictionaryapp.data.remote.repository


import com.example.dictionaryapp.data.remote.Word
import com.example.dictionaryapp.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

interface WordInfoRepository {

    fun getSearchWord(word : String) : Flow<Resource<Word>>

}