package com.example.dictionaryapp.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.dictionaryapp.DictionaryApp_GeneratedInjector
import com.example.dictionaryapp.data.remote.Item
import com.example.dictionaryapp.databinding.ActivityMainBinding
import com.example.dictionaryapp.databinding.DetailLayoutBinding
import com.example.dictionaryapp.viewmodel.DictionaryViewModel
import java.lang.RuntimeException

class DetailActivity : ComponentActivity() {
    val TAG = "sechan"
    private lateinit var binding : DetailLayoutBinding

    private val viewModel : DictionaryViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailLayoutBinding.inflate(layoutInflater).apply{
            lifecycleOwner = this@DetailActivity
        }
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Item>("data")
        binding.data = data
        
        Log.d(TAG, "onCreate: ${binding.data}")
    }
}