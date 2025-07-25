package com.loc.newsapp.feature.demo.data.repository
import com.loc.newsapp.feature.demo.domain.repository.DemoRepository
import com.loc.newsapp.feature.demo.data.data_source.DemoApiService
import com.loc.newsapp.feature.demo.data.model.DemoRequest
import com.loc.newsapp.feature.demo.data.model.DemoResponse

class DemoRepositoryImpl(
    private val demoApi: DemoApiService
) : DemoRepository {

    override suspend fun sendDemoData(request: DemoRequest): DemoResponse {
        return demoApi.sendData(/*request*/)
    }
}
