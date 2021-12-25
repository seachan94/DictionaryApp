package com.example.dictionaryapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionaryapp.data.remote.Item
import com.example.dictionaryapp.data.remote.Sense
import com.example.dictionaryapp.data.remote.Word
import com.example.dictionaryapp.databinding.ItemWordBinding
import javax.inject.Inject

class WordAdapter  :RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

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

    override fun getItemCount() = wordList.size

    fun setItem( data : Any?){
        val list = if(data == null) emptyList() else (data as Word).channel!!.item
        this.wordList = list
        notifyDataSetChanged()
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
}