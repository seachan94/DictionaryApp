package com.example.dictionaryapp.data.remote

import android.os.Parcelable
import androidx.room.ColumnInfo
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Channel(
    val item: List<Item>,
    val lastbuilddate: String,
    val link: String,
    val num: Int,
    val start: Int,
    val title: String,
    val total: Int
):Parcelable

@Parcelize
data class Item(
    val pos: String,
    val sense: Sense,
    val sup_no: String,
    val target_code: String,
    val word: String
):Parcelable{
    fun toXmlPosXml() : String{
        return "품사 : $pos\n"
    }
    fun toXmlNumberXml() : String{
        return "no.$sup_no\n"
    }
}

@Parcelize
data class Sense(
    val definition: String,
    val link: String,
    val type: String
):Parcelable{
    fun toXmlDefinition() : String{
        return "정의 : $definition"
    }
}

@Parcelize
data class Word(
    val channel: Channel?
):Parcelable