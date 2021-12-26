package com.example.dictionaryapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.dictionaryapp.data.remote.repository.DictionaryApi
import com.example.dictionaryapp.data.remote.repository.WordInfoRepository
import com.example.dictionaryapp.databinding.ActivityMainBinding
import com.example.dictionaryapp.ui.adapter.WordAdapter
import com.example.dictionaryapp.viewmodel.DictionaryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val TAG = "sechan"
    private lateinit var binding : ActivityMainBinding
    private val viewModel  by lazy {
        ViewModelProvider(this).get(DictionaryViewModel::class.java)
    }
       

    @Inject
    lateinit var wordAdapter : WordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater).apply{
            data = viewModel
            lifecycleOwner = this@MainActivity
        }

        setContentView(binding.root)
        binding.wordRecyclerview.adapter = wordAdapter

        wordAdapter.onClickDetail =  {
            Intent(this,DetailActivity::class.java).apply{
                putExtra("data",viewModel.wordData.value?.channel!!.item.get(it))
            }.run{
                    startActivity(this)
            }
        }
        
        binding.searchbtn.setOnClickListener {
            lifecycleScope.launch{
                viewModel.requestWord()
            }
        }

    }

}