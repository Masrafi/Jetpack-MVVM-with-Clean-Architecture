package com.loc.newsapp.feature.home.data.model

import com.loc.newsapp.feature.home.domain.entities.Article

data class HomeResponseModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)