package com.example.newsapi.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapi.R
import com.example.newsapi.data.constants.Constants.Companion.NO_CONNECTION
import com.example.newsapi.data.model.New
import com.example.newsapi.databinding.ActivityMainBinding
import com.example.newsapi.presentation.adapters.NewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var newAdapter: NewAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setContentView(binding.root)
        initViewModel()
        initAdapter()
        initObservers()
        initListeners()
    }

    private fun initListeners() {
        binding.buttonSearch.setOnClickListener {
            filterNewsByName()
        }

        binding.buttonClear.setOnClickListener {
            binding.searchBar.text.clear()
            filterNewsByName()
        }
    }

    private fun initViews() {
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    private fun initObservers() {
        mainViewModel.news.observe(this) { news: List<New?> ->
            newAdapter.updateNews(news)
        }

        mainViewModel.error.observe(this) { errorCode: Int ->
            val errorMessage = when (errorCode) {
                NO_CONNECTION -> getString(R.string.no_connection)
                else -> getString(R.string.error_general)
            }
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initAdapter() {
        newAdapter = NewAdapter(
            emptyList(),
            object : NewAdapter.OnNewClick {
                override fun onClick(new: New) {
                    Toast.makeText(this@MainActivity, "holi", Toast.LENGTH_SHORT).show()
                }
            }
        )
        binding.container.layoutManager = LinearLayoutManager(this)
        binding.container.adapter = newAdapter
    }

    private fun filterNewsByName() {
        mainViewModel.getNewsByName(binding.searchBar.text.toString())
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.getNews()
    }
}