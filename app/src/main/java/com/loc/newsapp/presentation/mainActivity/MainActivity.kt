package com.loc.newsapp.presentation.mainActivity
import dagger.hilt.android.AndroidEntryPoint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.loc.newsapp.ui.theme.NewsAppTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.core.view.WindowCompat
import androidx.activity.viewModels
import com.loc.newsapp.presentation.navgraph.NavGraph
import kotlinx.coroutines.launch
import android.util.Log
import com.loc.newsapp.presentation.onboadrding.OnBoardingViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition(condition = { viewModel.splashCondition.value })
        }
        setContent {
            NewsAppTheme(dynamicColor = false) {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    NavGraph(startDestination = viewModel.startDestination.value)
                }
            }
        }
    }
}
