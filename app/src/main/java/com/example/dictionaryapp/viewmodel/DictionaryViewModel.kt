package com.example.dictionaryapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionaryapp.data.WordInfoState
import com.example.dictionaryapp.data.remote.repository.DictionaryApi
import com.example.dictionaryapp.data.remote.repository.WordInfoRepository
import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo
import com.example.dictionaryapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@HiltViewModel
class DictionaryViewModel @Inject constructor(
    private val wordApi : WordInfoRepository
)  :ViewModel() {

    val TAG = "sechan"
    val searchText = MutableStateFlow("")

    private var _wordData = MutableLiveData(emptyList<WordInfo>())
    val wordData : LiveData<List<WordInfo>> get() = _wordData

    private var _resultState = MutableStateFlow<Resource<List<WordInfo>>>(Resource.Success(null))
    val resultState : StateFlow<Resource<List<WordInfo>>> get() = _resultState


    suspend fun requestWord()=
        wordApi.getSearchWord(searchText.value).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = Resource.Loading
        ).collect {
            Log.d(TAG, "requestWord: ${searchText.value}")
            when(it){
                is Resource.Loading ->{
                    _resultState.value =Resource.Loading
                }
                is Resource.Error ->{
                    _resultState.value = Resource.Error(it.message!!)
                }
                is Resource.Success->{
                    _wordData.value = it.data
                    _resultState.value = Resource.Success(_wordData.value)
                    Log.d(TAG, "requestWord: ${wordData.value}")
                }

            }
        }


}