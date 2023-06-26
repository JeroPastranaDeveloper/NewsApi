package com.example.newsapi.useCaseImplementations

import com.example.newsapi.data.model.New
import com.example.newsapi.data.repository.NewRepository
import com.example.newsapi.domain.usecase.NewUseCase
import javax.inject.Inject

class NewUseCaseImpl @Inject constructor(private val newRepository: NewRepository) : NewUseCase{
    override suspend fun getTopHeadlines(): List<New> {
        return newRepository.getTopHeadlines()
    }
}