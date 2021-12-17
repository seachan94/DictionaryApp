package com.example.dictionaryapp.feature_dictionary.data

import com.example.dictionaryapp.core.util.Resource
import com.example.dictionaryapp.feature_dictionary.data.local.WordInfoDao
import com.example.dictionaryapp.feature_dictionary.data.remote.DictionaryApi
import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo
import com.example.dictionaryapp.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api : DictionaryApi,
    private val dao : WordInfoDao
) : WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow{
        emit(Resource.Loading()) //프로그래스바

        val wordInfos = dao.getWordInfos(word).map{ it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordInfos = api.getWordInfo(word)
            dao.deleteWrodInfos(remoteWordInfos.map{ it.word })
            dao.insertWordInfos(remoteWordInfos.map{ it.toWordInfoEntity() })

        }catch (e : HttpException){
            emit(Resource.Error("Someting Wrong",wordInfos))
        }catch (e : IOException){
            emit(Resource.Error("인터넷을 확인해 주세요",wordInfos))
        }

        val newWordInfos = dao.getWordInfos(word).map{ it.toWordInfo() }
        emit(Resource.Success(newWordInfos))
    }

}