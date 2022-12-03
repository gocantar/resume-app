package com.gocantar.resume.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gocantar.resume.ui.components.NavigationBar
import com.gocantar.resume.ui.components.models.NavigationBarComposable
import com.gocantar.resume.ui.theme.AppTheme

class ResumeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                ResumeActivityContent(navController = navController)
            }
        }
    }
}

@Composable
fun ResumeActivityContent(navController: NavHostController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val destinationScreen = navBackStackEntry
        ?.destination
        ?.route
        ?: NavigationBarComposable.Home.route
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                ResumeNavHost(navController = navController)
            }
        },
        bottomBar = {
            NavigationBar(destinationScreen) { route ->
                navController.navigate(route) {
                    navController.graph.startDestinationRoute?.let { home ->
                        popUpTo(home) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    )
}
