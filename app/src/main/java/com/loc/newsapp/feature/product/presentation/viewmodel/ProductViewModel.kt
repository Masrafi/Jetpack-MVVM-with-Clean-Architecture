package com.loc.newsapp.feature.product.presentation.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.feature.product.data.data_source.ProductApiService
import com.loc.newsapp.feature.product.data.model.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(
    private val api: ProductApiService
) : ViewModel() {

    private val _productResponse = MutableStateFlow<ProductUiState>(ProductUiState.Idle)
    val productResponse: StateFlow<ProductUiState> = _productResponse

    fun sendProductData() {  /// This method will call in the button. Like event
        viewModelScope.launch {
            _productResponse.value = ProductUiState.Loading
            try {
                val response = api.sendData()
                println("✅ API Success: $response")
                _productResponse.value = ProductUiState.Success(response)
            } catch (e: Exception) {
                println("❌ API Error: ${e.localizedMessage}")
                e.printStackTrace()
                _productResponse.value = ProductUiState.Error(e.localizedMessage ?: "Unknown error")
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
sealed class ProductUiState {
    object Idle : ProductUiState()
    object Loading : ProductUiState()
    data class Success(val data: ProductModel) : ProductUiState()
    data class Error(val message: String) : ProductUiState()
}
