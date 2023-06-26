package com.example.newsapi.data.repositoryImplementations

import com.example.newsapi.data.model.New
import com.example.newsapi.data.repository.NewRepository
import com.example.newsapi.data.source.NewsDataSource
import javax.inject.Inject

class NewRepositoryImpl @Inject constructor(
    private val dataSource: NewsDataSource
) : NewRepository {
    override suspend fun getTopHeadlines(): List<New> {
        return dataSource.getTopHeadlines()
    }
}