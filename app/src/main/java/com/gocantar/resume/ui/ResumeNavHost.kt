package com.gocantar.resume.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gocantar.resume.ui.components.models.NavigationBarComposable
import com.gocantar.resume.ui.screens.EducationScreen
import com.gocantar.resume.ui.screens.ExperiencesScreen
import com.gocantar.resume.ui.screens.HomeScreen
import com.gocantar.resume.ui.screens.PortfolioScreen

@Composable
fun ResumeNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationBarComposable.Home.route) {
        composable(NavigationBarComposable.Home.route) {
            val viewModel = hiltViewModel<ResumeViewModel>()
            HomeScreen(viewModel)
        }
        composable(NavigationBarComposable.Experience.route) {
            ExperiencesScreen()
        }
        composable(NavigationBarComposable.Education.route) {
            EducationScreen()
        }
        composable(NavigationBarComposable.Portfolio.route) {
            PortfolioScreen()
        }
    }
}