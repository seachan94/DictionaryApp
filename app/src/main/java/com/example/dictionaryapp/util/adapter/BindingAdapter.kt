package com.example.dictionaryapp.util

import android.os.Build
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter

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
        var insertText = ""
        insertText = if(resource.data == null){
            ""
        } else{
            resource.data.toString()
        }
        text = insertText

    }
    else if (resource is Resource.Error){
        Toast.makeText(context,"잠시 후 다시 사용해 주세요",Toast.LENGTH_SHORT).show()
    }

}

@BindingAdapter("linkHtml")
fun TextView.link(value : String?){
    if(!value.isNullOrEmpty()){
        text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml("<a href=${value}>CLICK</a>", Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml("<a href=${value}>CLICK</a>")
        }
        movementMethod = LinkMovementMethod.getInstance()
        linksClickable = true
    }else{
        text = "Link가 없습니다."
    }
}