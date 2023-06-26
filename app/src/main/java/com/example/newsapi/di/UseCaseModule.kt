package com.example.newsapi.di

import com.example.newsapi.domain.usecase.NewUseCase
import com.example.newsapi.useCaseImplementations.NewUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun bindsNewUseCase(useCaseImpl: NewUseCaseImpl): NewUseCase
}