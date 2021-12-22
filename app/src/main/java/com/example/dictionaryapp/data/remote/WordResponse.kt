package com.example.dictionaryapp.feature_dictionary.domain.model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Definition(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
) :Parcelable

@Parcelize
data class Meaning(
    val definition: List<Definition>,
    val partOfSpeech : String
) : Parcelable

@Parcelize
data class WordInfo (
    val meanings: List<Meaning>,
    val origin :String,
    val phonetic: String,
    val word: String
):Parcelable