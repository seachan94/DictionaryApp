package com.example.dictionaryapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionaryapp.data.remote.Item
import com.example.dictionaryapp.data.remote.Sense
import com.example.dictionaryapp.data.remote.Word
import com.example.dictionaryapp.databinding.ItemWordBinding
import javax.inject.Inject

class WordAdapter  :ListAdapter<Item,WordAdapter.WordViewHolder>(DiffCallback) {

    lateinit var wordList : List<Item>
    var onClickDetail : ((Int)->Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(
            ItemWordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(wordList.get(position).sense,position)
    }


    fun setItem( data : Any?){
        val list = if(data == null) emptyList() else (data as Word).channel!!.item
        this.wordList = list
        Log.e("sechan", "setItem: submit!", )
        submitList(this.wordList)
    }

    inner class WordViewHolder(private val binding : ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(sense : Sense, position: Int){
            binding.apply{
                this.wordinfo =sense
                root.setOnClickListener {
                    onClickDetail?.invoke(position)
                }
            }
        }

    }

    object DiffCallback : DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem == newItem

    }
}