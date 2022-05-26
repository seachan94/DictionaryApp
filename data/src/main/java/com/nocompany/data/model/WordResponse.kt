package com.nocompany.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WordResponse(
    @SerialName("lastBuildDate") val lastBuildDate : String,
    @SerialName("total") val total : Int,
    @SerialName("start") val start : Int,
    @SerialName("display") val display : Int,
    @SerialName("items") val items : List<Item>
)
@Serializable
data class Item(
    val title : String,
    val link : String,
    val description : String,
    val thumbnail : String
)

