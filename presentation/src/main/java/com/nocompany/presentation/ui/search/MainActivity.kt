package com.nocompany.presentation.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import com.nocompany.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.lang.reflect.ParameterizedType

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
            searchBtn.setOnClickListener {
                viewModel.testcall()
                lifecycleScope.launch{

                    adapter.submitData(viewModel.testItem)
                    Log.d(TAG, "onCreate: ${adapter.snapshot().items}")
                }
            }

        }
        setContentView(binding.root)

    }
}