package com.loc.newsapp.feature.demo.presentation.screens
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.loc.newsapp.feature.demo.presentation.view_model.DemoUiState
import com.loc.newsapp.feature.demo.presentation.view_model.DemoViewModel

@Composable
fun DemoScreen(viewModel: DemoViewModel = hiltViewModel(), navigate:(String) -> Unit) {
    val state by viewModel.demoResponse.collectAsState()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (state) {
            is DemoUiState.Idle -> {
                Button(onClick = {  viewModel.sendDemoData() }) {
                    Text("Send Demo Data")
                }
            }
            is DemoUiState.Loading -> {
                CircularProgressIndicator()
            }
            is DemoUiState.Success -> {
                Text("Success: ${(state as DemoUiState.Success).data.response.data.amazon_version}")
            }
            is DemoUiState.Error -> {
                Text("Error: ${(state as DemoUiState.Error).message}", color = Color.Red)
            }
        }
    }
}