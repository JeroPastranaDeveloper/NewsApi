package com.example.newsapi.domain.usecase

import com.example.newsapi.data.model.New

interface NewUseCase {
    suspend fun getTopHeadlines(): List<New>
}