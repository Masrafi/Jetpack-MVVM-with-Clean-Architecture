package com.loc.newsapp.feature.demo.domain.usecases
import com.loc.newsapp.feature.demo.domain.repository.DemoRepository
import com.loc.newsapp.feature.demo.data.model.DemoRequest
import com.loc.newsapp.feature.demo.data.model.DemoResponse

class SendDemoDataUseCase(
    private val demoRepository: DemoRepository
) {
    suspend operator fun invoke(request: DemoRequest): DemoResponse {
        return demoRepository.sendDemoData(request)
    }
}
