package com.example.dictionaryapp.util

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionaryapp.data.remote.Channel
import com.example.dictionaryapp.data.remote.Item
import com.example.dictionaryapp.data.remote.Word
import com.example.dictionaryapp.ui.adapter.WordAdapter


@BindingAdapter("items")
fun <T> RecyclerView.setItems( resource: Resource<Any> ){
    if(resource is Resource.Success){
        val thisAdapter = if(adapter == null) WordAdapter() else adapter as WordAdapter
        thisAdapter.setItem(resource.data)
    }
}