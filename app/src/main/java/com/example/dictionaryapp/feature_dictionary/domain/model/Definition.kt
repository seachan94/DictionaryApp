package com.example.dictionaryapp.feature_dictionary.domain.model

import com.example.dictionaryapp.feature_dictionary.data.remote.dto.MeaningDto
import com.example.dictionaryapp.feature_dictionary.data.remote.dto.PhoneticDto

data class Definition(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
)
