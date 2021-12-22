package com.example.dictionaryapp.data.remote.repository

import android.util.Log
import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo
import com.example.dictionaryapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WordRepositoryImpl @Inject constructor(
    private val wordApi : DictionaryApi
) :WordInfoRepository{
    
    val TAG = "sechan"

    override fun getSearchWord(word: String): Flow<Resource<List<WordInfo>>> = flow{
        Log.d(TAG, "getSearchWord: start")
        val response : List<WordInfo> = wordApi.searchWordInfoEn(word)
        Log.d(TAG, "getSearchWord: $response")
        if(response.isNotEmpty()){
            emit(Resource.Success(response))
        }else{
            emit(Resource.Error("검색한 단어와 일치하는 것이 없습니다."))
        }
    }.catch {e->

        emit(Resource.Error("네트워크 에러입니다.\n 잠시 후 사용해 주세요"))
    }.flowOn(Dispatchers.IO)




}