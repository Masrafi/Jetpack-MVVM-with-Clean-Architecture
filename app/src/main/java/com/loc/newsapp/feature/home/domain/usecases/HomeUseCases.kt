package com.loc.newsapp.feature.home.domain.usecases

import androidx.paging.PagingData
import com.loc.newsapp.feature.home.domain.entities.Article
import com.loc.newsapp.feature.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class HomeUseCases(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return homeRepository.getNews(sources = sources) 
    }
}