package com.nocompany.presentation.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.nocompany.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    private val adapter by lazy{ WordListAdapter() }

    val TAG = "sechan"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.apply{
            vm = viewModel
            recyclerview.adapter = adapter
            lifecycleOwner = this@MainActivity
        }
        setContentView(binding.root)

    }
}