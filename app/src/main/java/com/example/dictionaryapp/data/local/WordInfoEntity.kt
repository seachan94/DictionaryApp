package com.example.dictionaryapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryapp.feature_dictionary.domain.model.Meaning
import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val meanings : List<Meaning>,
    val phonetic : String,
    val origin : String,
    val word : String,
    @PrimaryKey val id : Int? = null
){
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings,
            phonetic,
            word
        )
    }
}
