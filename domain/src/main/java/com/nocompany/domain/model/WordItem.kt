package com.nocompany.domain.model

data class WordItem(
    val items : List<Items>
)

data class Items(
    val title : String,
    val link : String,
    val description : String,
    val thumbnail : String
)