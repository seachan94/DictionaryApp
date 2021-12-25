package com.example.dictionaryapp.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import com.example.dictionaryapp.databinding.ActivityMainBinding
import com.example.dictionaryapp.databinding.DetailLayoutBinding

class DetailActivity : ComponentActivity() {
    val TAG = "sechan"
    private lateinit var binding : DetailLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailLayoutBinding.inflate(layoutInflater).apply{
            lifecycleOwner = this@DetailActivity
        }
        setContentView(binding.root)
    }
}