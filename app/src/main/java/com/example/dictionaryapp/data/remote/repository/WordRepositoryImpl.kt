package com.example.dictionaryapp.data.remote.repository

import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo
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


    override fun getSearchWord(word: String): Flow<Resource<List<WordInfo>>> = flow{
        val response : List<WordInfo> = wordApi.searchWordInfo(word)

        if(response.isNotEmpty()){
            emit(Resource.Success(response))
        }else{
            emit(Resource.Error("검색한 단어와 일치하는 것이 없습니다."))
        }
    }.catch {
        emit(Resource.Error("네트워크 에러입니다.\n 잠시 후 사용해 주세요"))
    }.flowOn(Dispatchers.IO)


}