package com.loc.newsapp.feature.product.domain.usecases
import com.loc.newsapp.feature.product.data.model.ProductModel
import com.loc.newsapp.feature.product.domain.repository.ProductRepository

class ProductUseCases(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(): ProductModel {
        return productRepository.sendProductData()
    }
}