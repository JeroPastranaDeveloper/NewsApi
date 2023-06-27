package com.example.newsapi.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapi.domain.usecase.NewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapi.data.constants.Constants.Companion.NO_CONNECTION
import com.example.newsapi.data.model.New
import com.example.newsapi.network.NetworkUtils
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val newUseCase: NewUseCase,
    private val networkUtils: NetworkUtils
) : ViewModel() {

    private val _allNews = MutableLiveData<List<New>>()
    private val _news = MutableLiveData<List<New>>()
    val news: LiveData<List<New>> get() = _news

    private val _error = MutableLiveData<Int>()
    val error: LiveData<Int> get() = _error

    fun getNews() = viewModelScope.launch {
        if (networkUtils.isNetworkAvailable()) {
            val news = newUseCase.getTopHeadlines()
            _allNews.postValue(news)
            _news.postValue(news)
        } else {
            _error.postValue(NO_CONNECTION)
        }
    }
}