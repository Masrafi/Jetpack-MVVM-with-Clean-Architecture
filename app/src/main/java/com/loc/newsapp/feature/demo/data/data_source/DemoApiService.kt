package com.loc.newsapp.feature.demo.data.data_source
import retrofit2.http.POST
import retrofit2.http.Body
import com.loc.newsapp.feature.demo.data.model.DemoRequest
import com.loc.newsapp.feature.demo.data.model.DemoResponse
import retrofit2.http.GET

interface DemoApiService {
    @GET("version")
    suspend fun sendData(
        //@Body request: DemoRequest
    ): DemoResponse
}