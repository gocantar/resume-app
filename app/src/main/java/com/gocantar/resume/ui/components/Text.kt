package com.gocantar.resume.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.gocantar.resume.ui.theme.AppTheme
import com.gocantar.resume.ui.theme.PoppinsTypography

@Composable
fun HeadLine5(
    text: String?,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onBackground,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) {
    text ?: return
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = PoppinsTypography.h5,
        textAlign = textAlign,
        maxLines = maxLines,
    )
}

@Composable
fun Subtitle(
    text: String?,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onBackground,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) {
    text ?: return
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = PoppinsTypography.subtitle1,
        textAlign = textAlign,
        maxLines = maxLines,
    )
}

@Composable
fun Body(
    text: String?,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onBackground,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) {
    text ?: return
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = PoppinsTypography.body1,
        textAlign = textAlign,
        maxLines = maxLines,
    )
}

@Composable
fun Link(
    text: String?,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onBackground,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) {
    text ?: return
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = PoppinsTypography.button,
        textAlign = textAlign,
        maxLines = maxLines,
    )
}

@Preview(showBackground = true)
@Composable
fun TextPreview() {
    AppTheme {
        Column {
            HeadLine5(text = "Headline5")
            Subtitle(text = "Subtitle")
            Body(text = "Body")
            Link(text = "Link")
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun TextPreviewDark() {
    AppTheme(darkTheme = true) {
        Column {
            HeadLine5(text = "Headline5")
            Subtitle(text = "Subtitle")
            Body(text = "Body")
            Link(text = "Link")
        }
    }
}