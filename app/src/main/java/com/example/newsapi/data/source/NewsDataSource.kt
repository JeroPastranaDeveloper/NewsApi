package com.example.newsapi.data.source

import com.example.newsapi.data.constants.Constants
import com.example.newsapi.data.model.New
import com.example.newsapi.data.model.NewResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSource @Inject constructor() {
    suspend fun getTopHeadlines(): List<New> {
        val response: Response<NewResponse> = RetrofitInstance.api.getTopHeadlines(Constants.LOCATION, Constants.API_KEY)
        return response.body()?.articles?.filterNotNull() ?: emptyList()
    }
}