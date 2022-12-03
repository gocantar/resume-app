package com.gocantar.resume.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Green500,
    primaryVariant = Green700,
    onPrimary = Color.Black,
    secondary = Teal700,
    secondaryVariant = Teal800,
    background = Color.Black,
    surface = Grey900
)

private val LightColorPalette = lightColors(
    primary = Green500,
    primaryVariant = Green700,
    onPrimary = Color.White,
    secondary = Teal700,
    secondaryVariant = Teal800,
    background = Color.White,
    surface = Grey100,
    /* Other default colors to override
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun AppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        typography = PoppinsTypography,
        shapes = Shapes,
        content = content
    )
}