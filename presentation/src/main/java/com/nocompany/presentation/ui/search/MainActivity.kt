package com.nocompany.presentation.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import com.nocompany.domain.model.WordItem
import com.nocompany.presentation.databinding.ActivityMainBinding
import com.nocompany.presentation.util.LoadFakeDataFromAssets
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
//                lifecycleScope.launch{
//                    adapter.submitData(viewModel.testItem)
//                }

            }

        }
        setContentView(binding.root)
        setOnclickItem()
        getFakeData()
    }
    private fun setOnclickItem(){
        adapter.onclick = {
            DetailInformationFragment().show(supportFragmentManager,DetailInformationFragment.TAG)
        }
    }


    private fun getFakeData(){
        val fakeData = LoadFakeDataFromAssets(this)
            .getObjectFromJson<WordItem>(
                "fake_word_response.json",WordItem::class.java
            )

        lifecycleScope.launch{
            adapter.submitData(PagingData.from(fakeData.items))
        }
    }
}