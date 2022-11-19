package com.gocantar.resume.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.gocantar.resume.ui.components.NavigationBar
import com.gocantar.resume.ui.components.models.NavigationBarComposable
import com.gocantar.resume.ui.theme.AppTheme

class ResumeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                val screen = remember { mutableStateOf(NavigationBarComposable.Home.route) }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = { padding ->
                        Box(modifier = Modifier.padding(padding)) {
                            ResumeNavHost(navController = navController)
                        }
                    },
                    bottomBar = {
                        NavigationBar(screen.value) { route ->
                            navController.navigate(route) {
                                navController.graph.startDestinationRoute?.let { home ->
                                    popUpTo(home) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                            screen.value = route
                        }
                    }
                )
            }
        }
    }
}
