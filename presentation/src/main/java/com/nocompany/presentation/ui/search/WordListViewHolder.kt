package com.nocompany.presentation.ui.search

import androidx.recyclerview.widget.RecyclerView
import com.nocompany.domain.model.Items
import com.nocompany.domain.model.WordItem
import com.nocompany.presentation.databinding.ItemWordBinding

class WordListViewHolder(
    private val binding : ItemWordBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem( item : Items){
        binding.apply{
            data = item
        }
    }
}