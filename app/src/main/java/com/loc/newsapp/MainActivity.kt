package com.loc.newsapp
import dagger.hilt.android.AndroidEntryPoint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.loc.newsapp.presentation.onboadrding.OnBoardingScreen
import com.loc.newsapp.ui.theme.NewsAppTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import javax.inject.Inject
import com.loc.newsapp.domain.usecase.AppEntryUseCases
import kotlinx.coroutines.launch
import android.util.Log

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var useCases: AppEntryUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        lifecycleScope.launch {
            useCases.readAppEntry().collect {
            Log.d("Test", it.toString())   /// test purpose. You can see it in Logcat in the bottom
          }
        }
        setContent {
            NewsAppTheme {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {/// this for theme
                    OnBoardingScreen()
                }
            }
        }
    }
}
