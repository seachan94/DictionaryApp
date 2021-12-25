package com.example.dictionaryapp.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionaryapp.data.remote.Word
import com.example.dictionaryapp.data.remote.repository.WordInfoRepository
import com.example.dictionaryapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class DictionaryViewModel @Inject constructor(
    private val wordApi : WordInfoRepository
)  :ViewModel() {

    val TAG = "sechan"
    val searchText = MutableStateFlow("")

    private var _wordData = MutableLiveData(Word(null))
    val wordData : LiveData<Word> get() = _wordData

    private var _resultState = MutableStateFlow<Resource<Word>>(Resource.Success(null))
    val resultState : StateFlow<Resource<Word>> get() = _resultState


    suspend fun requestWord()=
        wordApi.getSearchWord(searchText.value).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = Resource.Loading
        ).collect {

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