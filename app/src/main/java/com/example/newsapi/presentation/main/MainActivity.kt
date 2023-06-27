package com.example.newsapi.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.newsapi.data.model.New
import com.example.newsapi.databinding.ActivityMainBinding
import com.example.newsapi.presentation.adapters.NewAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var newAdapter: NewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setContentView(binding.root)
        initAdapter()

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
    }

    private fun initViews() {
        installSplashScreen()
    }
}