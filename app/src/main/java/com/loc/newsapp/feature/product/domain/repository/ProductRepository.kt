package com.loc.newsapp.feature.product.domain.repository
import com.loc.newsapp.feature.product.data.model.ProductModel


interface ProductRepository {
    suspend fun sendProductData(): ProductModel
}
