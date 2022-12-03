package com.gocantar.resume.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gocantar.resume.ui.components.models.NavigationBarComposable
import com.gocantar.resume.ui.theme.AppTheme

@Composable
fun NavigationBar(
    currentRoute: String,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {}
) {

    val items = listOf(
        NavigationBarComposable.Home,
        NavigationBarComposable.Experience,
        NavigationBarComposable.Education,
        NavigationBarComposable.Portfolio
    )

    BottomAppBar(
        modifier = modifier.testTag("navigation-bar"),
        backgroundColor = MaterialTheme.colors.background
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            items.forEach { navigationBarItem ->
                NavigationBarItem(
                    item = navigationBarItem,
                    selected = currentRoute == navigationBarItem.route
                ) {
                    onClick(navigationBarItem.route)
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
    val selectedColor = animateColorAsState(
        if (selected) MaterialTheme.colors.primaryVariant else MaterialTheme.colors.background
    )
    val tint = animateColorAsState(
        if (selected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onBackground
    )
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(selectedColor.value, shape = CircleShape)
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
            tint = tint.value,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NavigationBarPreview() {
    AppTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            NavigationBar(NavigationBarComposable.Home.route)
            NavigationBar(NavigationBarComposable.Experience.route)
            NavigationBar(NavigationBarComposable.Education.route)
            NavigationBar(NavigationBarComposable.Portfolio.route)
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
private fun NavigationBarPreviewDark() {
    AppTheme(darkTheme = true) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            NavigationBar(NavigationBarComposable.Home.route)
            NavigationBar(NavigationBarComposable.Experience.route)
            NavigationBar(NavigationBarComposable.Education.route)
            NavigationBar(NavigationBarComposable.Portfolio.route)
        }
    }
}