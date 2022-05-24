package com.nocompany.presentation.ui.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nocompany.domain.model.Items
import com.nocompany.domain.model.ResultState
import com.nocompany.domain.model.WordItem
import com.nocompany.domain.usecase.GetSearchListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val wordUseCase : GetSearchListUseCase
): ViewModel() {

    val TAG = "sechan"

    private var _resultState = MutableStateFlow<ResultState<List<Items>>>(ResultState.Success(listOf()))
    val resultState : StateFlow<ResultState<List<Items>>> get() = _resultState



}