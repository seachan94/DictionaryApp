package com.example.dictionaryapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.dictionaryapp.data.remote.repository.DictionaryApi
import com.example.dictionaryapp.data.remote.repository.WordInfoRepository
import com.example.dictionaryapp.databinding.ActivityMainBinding
import com.example.dictionaryapp.viewmodel.DictionaryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val TAG = "sechan"
    private lateinit var binding : ActivityMainBinding
    private val viewModel : DictionaryViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchbtn.setOnClickListener {
            lifecycleScope.launch{
                Log.d(TAG, "onCreate: clickBtn")
                viewModel.requestWord()
            }

        }
    }
}