package com.nocompany.presentation.util

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nocompany.domain.model.WordItem
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Type

class LoadFakeDataFromAssets(
    @ApplicationContext
    private val context : Context
) {
    private val gson = Gson()

    fun<T> getObjectFromJson(fileName: String,type : Type) : T {
        val message = readMockFileToString(fileName)
        return gson.fromJson(message,type)
    }

    private fun readMockFileToString(fileName : String) =
        try{
            val inputStream = context.assets.open(fileName)

            inputStream.bufferedReader()
                .use{
                    it.readText()
                }
        }catch (e : IOException){
            throw(e)
        }
}

