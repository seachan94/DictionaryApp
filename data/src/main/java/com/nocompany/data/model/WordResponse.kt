package com.nocompany.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WordResponse(
    @SerialName("lastBuildDate") val lastBuildDate : String,
    @SerialName("total") val total : Int,
    @SerialName("start") val start : Int,
    @SerialName("display") val display : Int,
    @SerialName("items") val items : List<Items>
)
@Serializable
data class Items(
    @SerialName("title") val title : String,
    @SerialName("link") val link : String,
    @SerialName("description") val description : String,
    @SerialName("thumbnail") val thumbnail : String
)

