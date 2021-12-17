package com.example.dictionaryapp.feature_dictionary.domain.model

data class Meaning(
    val definition: List<Definition>,
    val partOfSpeech : String
)
