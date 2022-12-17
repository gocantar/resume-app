package com.gocantar.resume.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.gocantar.resume.data.Profile
import com.gocantar.resume.data.Skills
import com.gocantar.resume.ui.components.FadingAppBar
import com.gocantar.resume.ui.components.Header
import com.gocantar.resume.ui.components.Skills
import com.gocantar.resume.ui.components.extensions.toHeaderName
import com.gocantar.resume.ui.components.models.SkillsComposable
import com.gocantar.resume.ui.ResumeViewModel

@Composable
fun HomeScreen(viewModel: ResumeViewModel) {
    Box(modifier = Modifier
        .fillMaxSize()
        .testTag("home-screen")
    ) {
        val scrollState = rememberLazyListState()
        LazyColumn(state = scrollState) {
            item {
                Header(
                    header = Profile.value,
                    onClickButton = { viewModel.downloadPdf() }
                )
            }
            item {
                Skills (
                    skills = SkillsComposable(
                        header = "Aptitudes",
                        items = Skills.items
                    )
                )
            }
        }
        FadingAppBar(
            title = Profile.value.toHeaderName(),
            scrollState = scrollState
        )
    }
}
