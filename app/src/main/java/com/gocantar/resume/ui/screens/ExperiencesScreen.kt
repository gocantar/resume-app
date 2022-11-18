package com.gocantar.resume.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gocantar.resume.ui.components.HeadLine5
import com.gocantar.resume.ui.theme.AppTheme

@Composable
fun ExperiencesScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        HeadLine5("Experiencias")
    }
}

@Preview(showBackground = true)
@Composable
private fun ExperiencesScreenPreview() {
    AppTheme {
        ExperiencesScreen()
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
private fun ExperiencesScreenDarkPreview() {
    AppTheme(darkTheme = true) {
        ExperiencesScreen()
    }
}