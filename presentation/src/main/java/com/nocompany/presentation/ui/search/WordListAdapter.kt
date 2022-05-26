package com.nocompany.presentation.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.nocompany.domain.model.Items
import com.nocompany.domain.model.WordItem
import com.nocompany.presentation.databinding.ItemWordBinding

class WordListAdapter : PagingDataAdapter<Items, WordListViewHolder>(Differ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordListViewHolder {
        return WordListViewHolder(
            ItemWordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WordListViewHolder, position: Int) {
        getItem(position)?.let{
            holder.bindItem(it)
        }
    }

    object Differ : DiffUtil.ItemCallback<Items>() {
        override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem.thumbnail == newItem.thumbnail
        }

        override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem == newItem
        }
    }


}