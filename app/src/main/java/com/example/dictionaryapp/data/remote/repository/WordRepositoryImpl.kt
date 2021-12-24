package com.example.dictionaryapp.data.remote.repository

import android.util.Log
import androidx.compose.ui.input.key.Key
import com.example.dictionaryapp.data.remote.Word

import com.example.dictionaryapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class WordRepositoryImpl @Inject constructor(
    private val wordApi : DictionaryApi
) :WordInfoRepository{

    companion object {
        val KEY : String = "8630CFE4A313C101CF222E0B3469F641"
        val REQ_TYPE = "json"
        val TAG = "sechan"
    }


    override fun getSearchWord(word: String): Flow<Resource<Word>> = flow {

        emit(Resource.Loading)
        val response =wordApi.searchWordInfo(KEY, REQ_TYPE,word)

        if(response.channel?.item!!.isEmpty()){
            emit(Resource.Error("찾으시는 글자 사전이 없습니다."))
        }else{
            emit(Resource.Success(response))
        }
    }.catch {e->
        Log.e(TAG, "getSearchWord: ${e.message}", )
        emit(Resource.Error("네트워크 에러"))
    }.flowOn(Dispatchers.IO)



}