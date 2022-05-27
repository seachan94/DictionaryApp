package com.nocompany.presentation.ui.search

import androidx.recyclerview.widget.RecyclerView
import com.nocompany.domain.model.Items
import com.nocompany.domain.model.WordItem
import com.nocompany.presentation.databinding.ItemWordBinding

class WordListViewHolder(
    private val binding : ItemWordBinding,
    private val onclick : (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem( item : Items, position : Int){
        binding.apply{
            data = item
            root.setOnClickListener {
                onclick.invoke(position)
            }
        }
    }
}