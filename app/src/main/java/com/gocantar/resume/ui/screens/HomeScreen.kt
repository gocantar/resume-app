package com.gocantar.resume.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gocantar.resume.data.Profile
import com.gocantar.resume.data.Skills
import com.gocantar.resume.ui.components.AppBar
import com.gocantar.resume.ui.components.FadingAppBar
import com.gocantar.resume.ui.components.HeadLine5
import com.gocantar.resume.ui.components.Header
import com.gocantar.resume.ui.components.Skills
import com.gocantar.resume.ui.components.models.SkillComposable
import com.gocantar.resume.ui.components.models.SkillsComposable
import com.gocantar.resume.ui.theme.AppTheme

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()
    ) {
        val scrollState = rememberLazyListState()
        LazyColumn(state = scrollState) {
            item {
                Header(header = Profile.value)
            }
            item {
                Skills(
                    skills = SkillsComposable(
                        header = "Aptitudes técnicas",
                        items = Skills.Hard.items
                    )
                )
            }
        }
        FadingAppBar(
            title = Profile.value.firstName,
            scrollState = scrollState
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    AppTheme {
        HomeScreen()
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
private fun HomeScreenDarkPreview() {
    AppTheme(darkTheme = true) {
        HomeScreen()
    }
}