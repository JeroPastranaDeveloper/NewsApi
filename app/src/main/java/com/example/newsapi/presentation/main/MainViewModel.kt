package com.example.newsapi.presentation.main

import androidx.lifecycle.ViewModel
import com.example.newsapi.domain.usecase.NewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val newUseCase: NewUseCase
) : ViewModel() {

    fun getNews() = viewModelScope.launch
}