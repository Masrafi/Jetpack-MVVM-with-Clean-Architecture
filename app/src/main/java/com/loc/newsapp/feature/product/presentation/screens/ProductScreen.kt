package com.loc.newsapp.feature.product.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.loc.newsapp.feature.product.presentation.viewmodel.ProductUiState
import com.loc.newsapp.feature.product.presentation.viewmodel.ProductViewModel

@Composable
fun ProductScreen(viewModel: ProductViewModel = hiltViewModel(), navigate:(String) -> Unit) {
    val state by viewModel.productResponse.collectAsState()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (state) {
            is ProductUiState.Idle -> {
                Button(onClick = {  viewModel.sendProductData() }) {
                    Text("Send Demo Data")
                }
            }
            is ProductUiState.Loading -> {
                CircularProgressIndicator()
            }
            is ProductUiState.Success -> {
                //Text("Success: ${(state as ProductUiState.Success).data[0].category}")
                val productList = (state as ProductUiState.Success).data

                LazyColumn {
                    items(productList) { product ->
                        Text("Category: ${product.category}")
                        // Add more fields as needed, e.g.:
                        // Text("Name: ${product.name}")
                        // Divider()
                    }
                }
            }
            is ProductUiState.Error -> {
                Text("Error: ${(state as ProductUiState.Error).message}", color = Color.Red)
            }
        }
    }
}