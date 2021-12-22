package com.example.dictionaryapp.data

import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems : List<WordInfo> = emptyList(),
    val isLoading : Boolean = false
)
