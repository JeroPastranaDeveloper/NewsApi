package com.example.newsapi.data.model

data class New(
	val articles: List<ArticlesItem?>? = null
)

data class Source(
	val name: String? = null,
	val id: String? = null
)

data class ArticlesItem(
	val publishedAt: String? = null,
	val author: String? = null,
	val urlToImage: String? = null,
	val description: String? = null,
	val source: Source? = null,
	val title: String? = null,
	val url: String? = null,
	val content: String? = null
)

