package com.gocantar.resume.ui.components.models

import com.gocantar.resume.R

sealed class NavigationBarComposable(val title: String, val icon: Int, val route: String) {
    object Home : NavigationBarComposable(
        title = "Home",
        icon = R.drawable.ic_home,
        route = "home"
    )
    object Experience : NavigationBarComposable(
        title = "Experience",
        icon = R.drawable.ic_work,
        route = "experience"
    )
    object Studies : NavigationBarComposable(
        title = "Studies",
        icon = R.drawable.ic_degree,
        route = "studies"
    )
    object Portfolio : NavigationBarComposable(
        title = "Portfolio",
        icon = R.drawable.ic_workspace,
        route = "portfolio"
    )
}