package com.loc.newsapp.feature.demo.presentation.view_model
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.feature.demo.data.model.DemoResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.loc.newsapp.feature.demo.data.data_source.DemoApiService

@HiltViewModel
class DemoViewModel @Inject constructor(
    private val api: DemoApiService
) : ViewModel() {

    private val _demoResponse = MutableStateFlow<DemoUiState>(DemoUiState.Idle)
    val demoResponse: StateFlow<DemoUiState> = _demoResponse

    fun sendDemoData() {
        viewModelScope.launch {
            _demoResponse.value = DemoUiState.Loading
            try {
                val response = api.sendData()
                println("✅ API Success: $response")
                _demoResponse.value = DemoUiState.Success(response)
            } catch (e: Exception) {
                println("❌ API Error: ${e.localizedMessage}")
                e.printStackTrace()
                _demoResponse.value = DemoUiState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }
}


//sealed interface DemoUiState {
//    object Idle : DemoUiState
//    object Loading : DemoUiState
//    data class Success(val message: DemoResponse) : DemoUiState
//    data class Error(val error: String) : DemoUiState
//}
sealed class DemoUiState {
    object Idle : DemoUiState()
    object Loading : DemoUiState()
    data class Success(val data: DemoResponse) : DemoUiState()
    data class Error(val message: String) : DemoUiState()
}


