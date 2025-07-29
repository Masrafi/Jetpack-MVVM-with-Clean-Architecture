package com.loc.newsapp.config.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.loc.newsapp.feature.demo.presentation.view_model.DemoViewModel
import com.loc.newsapp.feature.home.presentation.screens.HomeScreen
import com.loc.newsapp.feature.home.presentation.viewmodel.HomeViewModel
import com.loc.newsapp.feature.onBoarding.presentation.onboadrding.OnBoardingScreen
import com.loc.newsapp.feature.onBoarding.presentation.onboadrding.OnBoardingViewModel
import com.loc.newsapp.feature.demo.presentation.screens.DemoScreen
import com.loc.newsapp.feature.product.presentation.viewmodel.ProductViewModel
import com.loc.newsapp.feature.product.presentation.screens.ProductScreen

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onEvent = viewModel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.HomeScreen.route
        ) {
            composable(route = Route.HomeScreen.route) {
                val viewModel: HomeViewModel = hiltViewModel()
                val articles = viewModel.homeData.collectAsLazyPagingItems()
                HomeScreen(
                    articles = articles,
                    navigate = { route ->
                        navController.navigate(route)
                    }
                )

            }
            composable(route = Route.DemoScreen.route) {
                val viewModel: DemoViewModel = hiltViewModel()
                DemoScreen(viewModel = viewModel, navigate = { route ->
                    navController.navigate(route)
                })
            }            
            
            composable(route = Route.ProductScreen.route) {
                val viewModel: ProductViewModel = hiltViewModel()
                ProductScreen(viewModel = viewModel, navigate = {})
            }

        }
    }
}