package com.gocantar.resume.components.mocks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gocantar.resume.ui.components.models.NavigationBarComposable

@Composable
fun TestNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationBarComposable.Home.route) {
        composable(NavigationBarComposable.Home.route) {
            HomeScreen()
        }
        composable(NavigationBarComposable.Experience.route) {
            ExperiencesScreen()
        }
        composable(NavigationBarComposable.Studies.route) {
            StudiesScreen()
        }
        composable(NavigationBarComposable.Portfolio.route) {
            PortfolioScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Home")
    }
}

@Composable
fun ExperiencesScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Experiences")
    }
}

@Composable
fun StudiesScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Studies")
    }
}

@Composable
fun PortfolioScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Portfolio")
    }
}