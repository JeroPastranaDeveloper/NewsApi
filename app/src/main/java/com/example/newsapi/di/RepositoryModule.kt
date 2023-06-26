package com.example.newsapi.di

import com.example.newsapi.data.repository.NewRepository
import com.example.newsapi.data.repositoryImplementations.NewRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsNewRepository(repositoryImpl: NewRepositoryImpl): NewRepository
}