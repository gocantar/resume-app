package com.gocantar.resume.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gocantar.resume.ui.components.models.NavigationBarComposable
import com.gocantar.resume.ui.theme.AppTheme

@Composable
fun NavigationBar(navController: NavController) {

    val items = listOf(
        NavigationBarComposable.Home,
        NavigationBarComposable.Experience,
        NavigationBarComposable.Studies,
        NavigationBarComposable.Portfolio
    )

    BottomAppBar(
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp
    ) {
        val navigationStack by navController.currentBackStackEntryAsState()
        val route = navigationStack?.destination?.route
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            items.forEach {
                NavigationBarItem(item = it, selected = route == it.route) {
                    navController.navigate(it.route) {
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
        }
    }
}

@Composable
private fun NavigationBarItem(
    item: NavigationBarComposable,
    selected: Boolean,
    onClick: () -> Unit
) {
    val selectedColor by animateColorAsState(
        if (selected) MaterialTheme.colors.primary else MaterialTheme.colors.background
    )
    val tint by animateColorAsState(
        if (selected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onBackground
    )
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(selectedColor, shape = CircleShape)
            .selectable(
                selected = selected,
                interactionSource = MutableInteractionSource(),
                indication = null
            ) { onClick() }
            .testTag(item.route),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = item.icon),
            tint = tint,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    AppTheme {
        NavigationBar(rememberNavController())
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun NavigationPreviewDark() {
    AppTheme(darkTheme = true) {
        NavigationBar(rememberNavController())
    }
}