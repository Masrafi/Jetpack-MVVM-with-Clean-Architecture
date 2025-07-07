package com.loc.newsapp.feature.home.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.loc.newsapp.feature.home.domain.repository.HomeRepository
import com.loc.newsapp.feature.home.domain.entities.Article
//import com.loc.newsapp.data.remote.SearchNewsPagingSource
import com.loc.newsapp.feature.home.data.data_source.HomeApiService
import com.loc.newsapp.core.util.PagingSource
import kotlinx.coroutines.flow.Flow

class HomeRepositoryImpl(
    private val newsApi: HomeApiService
    ): HomeRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                PagingSource(newsApi = newsApi, sources = sources.joinToString(separator = ","))
            }
        ).flow
    }
}