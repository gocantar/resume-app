package com.gocantar.resume.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gocantar.resume.R
import com.gocantar.resume.ui.components.models.NavigationBarComposable
import com.gocantar.resume.ui.extensions.toAlpha
import com.gocantar.resume.ui.theme.AppTheme

@Composable
fun FadingAppBar(
    title: String,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState()
) {
    val alpha = scrollState.toAlpha(LocalDensity.current.run { 56.dp.roundToPx() })
    AppBar(title = title, modifier = modifier.alpha(alpha))
}

@Composable
fun AppBar(
    title: String,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeadLine5(
                text = title,
                modifier = Modifier.weight(1F)
            )
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.image_profile),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppBarPreview() {
    AppTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FadingAppBar(
                title = "Fading Title",
                scrollState = rememberScrollState(0)
            )
            FadingAppBar(
                title = "Fading Title",
                scrollState = rememberScrollState(10)
            )
            FadingAppBar(
                title = "Fading Title",
                scrollState = rememberScrollState(100)
            )
            FadingAppBar(
                title = "Fading Title",
                scrollState = rememberScrollState(200)
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
private fun AppBarPreviewDark() {
    AppTheme(darkTheme = true) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FadingAppBar(
                title = "Fading Title",
                scrollState = rememberScrollState(0)
            )
            FadingAppBar(
                title = "Fading Title",
                scrollState = rememberScrollState(10)
            )
            FadingAppBar(
                title = "Fading Title",
                scrollState = rememberScrollState(100)
            )
            FadingAppBar(
                title = "Fading Title",
                scrollState = rememberScrollState(200)
            )
        }
    }
}