package com.loc.newsapp.feature.product.data.data_source
import com.loc.newsapp.feature.product.data.model.ProductModel
import retrofit2.http.GET

interface ProductApiService {
    @GET("products")
    suspend fun sendData(
        //@Body request: DemoRequest
    ): ProductModel
}