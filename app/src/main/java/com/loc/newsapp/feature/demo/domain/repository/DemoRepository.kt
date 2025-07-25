package com.loc.newsapp.feature.demo.domain.repository
import com.loc.newsapp.feature.demo.data.model.DemoRequest
import com.loc.newsapp.feature.demo.data.model.DemoResponse


interface DemoRepository {
    suspend fun sendDemoData(request: DemoRequest): DemoResponse
}
