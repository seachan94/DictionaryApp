package com.nocompany.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nocompany.domain.model.NetworkResult
import com.nocompany.domain.usecase.GetSearchListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val wordUseCase : GetSearchListUseCase
): ViewModel() {

    val TAG = "sechan"

}