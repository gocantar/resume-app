package com.gocantar.resume.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gocantar.resume.R
import com.gocantar.resume.ui.theme.AppTheme

@Composable
fun PrimaryButton(
    text: String?,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        onClick = onClick
    ) {
        icon?.let {
            Icon(
                modifier = Modifier
                    .padding(end = ButtonDefaults.IconSpacing)
                    .size(ButtonDefaults.IconSize),
                painter = painterResource(id = it),
                contentDescription = null
            )
        }
        Link(text = text, color = MaterialTheme.colors.onPrimary)
    }
}

@Composable
fun ButtonLink(
    text: String?,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    onClick: () -> Unit = {}
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        contentPadding = ButtonDefaults.ContentPadding
    ) {
        icon?.let {
            Icon(
                modifier = Modifier
                    .padding(end = ButtonDefaults.IconSpacing)
                    .size(ButtonDefaults.IconSize),
                painter = painterResource(id = it),
                contentDescription = null
            )
        }
        Link(
            text = text,
            color = MaterialTheme.colors.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    AppTheme {
        Column(Modifier.padding(16.dp)) {
            PrimaryButton(text = "Primary button")
            PrimaryButton(text = "Primary button icon", icon = R.drawable.ic_cloud_download)
            ButtonLink(text = "Link button")
            ButtonLink(text = "Link button icon", icon = R.drawable.ic_contact)
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun ButtonPreviewDark() {
    AppTheme(darkTheme = true) {
        Column(Modifier.padding(16.dp)) {
            PrimaryButton(text = "Primary button")
            PrimaryButton(text = "Primary button icon", icon = R.drawable.ic_cloud_download)
            ButtonLink(text = "Link button")
            ButtonLink(text = "Link button icon", icon = R.drawable.ic_contact)
        }
    }
}