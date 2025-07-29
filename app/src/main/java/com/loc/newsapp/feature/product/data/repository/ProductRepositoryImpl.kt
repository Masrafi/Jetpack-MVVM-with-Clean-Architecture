package com.loc.newsapp.feature.product.data.repository
import com.loc.newsapp.feature.product.data.data_source.ProductApiService
import com.loc.newsapp.feature.product.data.model.ProductModel
import com.loc.newsapp.feature.product.domain.repository.ProductRepository


class ProductRepositoryImpl(
    private val productApi: ProductApiService
) : ProductRepository {
    override suspend fun sendProductData(): ProductModel {
        return productApi.sendData()
    }
}