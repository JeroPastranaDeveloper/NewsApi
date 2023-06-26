package com.example.newsapi.data.source

import com.example.newsapi.data.constants.Constants
import com.example.newsapi.data.model.NewResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query(Constants.COUNTRY) country: String,
        @Query(Constants.API_KEY_RAW) apiKey: String
    ): Response<NewResponse>
}