package com.gocantar.resume.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gocantar.resume.R
import com.gocantar.resume.ui.components.models.ProfileHeaderComposable
import com.gocantar.resume.ui.theme.AppTheme

@Composable
fun Header(
    header: ProfileHeaderComposable,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        ProfileHeader(header = header)
        Body(text = header.description, textAlign = TextAlign.Justify)
        Spacer(modifier = Modifier.height(16.dp))
        PrimaryButton(text = "Descargar", icon = R.drawable.ic_cloud_download)
        Spacer(modifier = Modifier.height(8.dp))
        ButtonLink(text = "Contacto", icon = R.drawable.ic_contact)
    }
}

@Composable
private fun ProfileHeader(header: ProfileHeaderComposable) {
    Box(modifier = Modifier.padding(bottom = 16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Column(
                modifier = Modifier.weight(1F)
            ) {
                HeadLine5(text = "Hola")
                Subtitle(text = "Mi nombre es")
                Subtitle(text = "${header.firstName} ${header.secondName}")
            }
            Image(
                modifier = Modifier
                    .size(150.dp)
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
fun HeaderPreview() {
    AppTheme {
        Header(
            header = ProfileHeaderComposable(
                firstName = "Gonzalo",
                secondName = "Cantarero",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                        "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad " +
                        "minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                        "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
                        "voluptate velit esse cillum dolore eu fugiat nulla pariatur"
            ),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 16.dp)
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun HeaderPreviewDark() {
    AppTheme(darkTheme = true) {
        Header(
            header = ProfileHeaderComposable(
                firstName = "Gonzalo",
                secondName = "Cantarero",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                        "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad " +
                        "minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                        "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
                        "voluptate velit esse cillum dolore eu fugiat nulla pariatur"
            ),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 16.dp)
        )
    }
}