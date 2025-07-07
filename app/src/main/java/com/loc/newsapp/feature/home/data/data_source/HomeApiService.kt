package com.loc.newsapp.feature.home.data.data_source

import com.loc.newsapp.core.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query
import com.loc.newsapp.feature.home.data.model.HomeResponseModel

interface HomeApiService {

    @GET("everything")
    suspend fun getNews(
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): HomeResponseModel

//    @GET("everything")
//    suspend fun searchNews(
//        @Query("q") searchQuery: String,
//        @Query("sources") sources: String,
//        @Query("page") page: Int,
//        @Query("apiKey") apiKey: String = API_KEY
//    ): NewsResponse
}