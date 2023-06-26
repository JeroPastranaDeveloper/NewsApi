package com.example.newsapi.data.source

import com.example.newsapi.data.model.New
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Response<New>
}