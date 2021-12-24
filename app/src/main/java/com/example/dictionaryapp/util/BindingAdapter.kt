package com.example.dictionaryapp.util

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo

@BindingAdapter("showProgressBar")
fun ProgressBar.bindProgressBar(resource : Resource<Any>){
    visibility = if( resource is Resource.Loading){
        View.VISIBLE
    }else{
        View.GONE
    }
}

@BindingAdapter("wordText")
fun TextView.wordTextSplit( resource : Resource<Any>){



    if(resource is Resource.Success){
        val wordInfoData = resource.data as? ArrayList<WordInfo>
        var word :String = ""
        wordInfoData?.forEach { wordInfo->
            word += "word : " + wordInfo.word+"\n" +"phonetic : " +wordInfo.phonetic+"\n\n"
            wordInfo.meanings.forEach { meaning ->
                word += "partOfSpeech : "+ meaning.partOfSpeech+"\n\n"
                meaning.definitions.forEach { define ->
                    word+= "definition : "+define.definition +"\n\n"
                    word+= "exampe : " + define.example +"\n\n"
                }
            }
        }
        text = word
    }
    else if (resource is Resource.Error){
        Toast.makeText(context,"잠시 후 다시 사용해 주세요",Toast.LENGTH_SHORT).show()
    }

}