package com.example.newsapi.data.repository

import com.example.newsapi.data.model.New

interface NewRepository {
    suspend fun getTopHeadlines(): List<New>
}