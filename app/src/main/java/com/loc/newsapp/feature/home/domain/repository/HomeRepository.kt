package com.loc.newsapp.feature.home.domain.repository

import androidx.paging.PagingData
import com.loc.newsapp.feature.home.domain.entities.Article
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getNews(sources: List<String>): Flow<PagingData<Article>>
    //fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>
}