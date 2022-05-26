package com.nocompany.presentation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nocompany.domain.model.ResultState
import com.nocompany.presentation.R

@BindingAdapter("setItemsFromNetWork")
fun<T> RecyclerView.setItemToRecyclerView(resultState : ResultState<List<T>>?){
    if( resultState is ResultState.Success){
        (adapter as ListAdapter<T,*>).submitList(resultState.data)
    }
}

@BindingAdapter("imgUrl")
fun ImageView.loadThumbnail( url : String?){
    val loadUrl = if(url.isNullOrBlank()) R.drawable.ex else url
    Glide.with(context)
        .load(loadUrl)
        .centerCrop()
        .into(this)
}