package com.gocantar.resume.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gocantar.resume.R
import com.gocantar.resume.data.Profile
import com.gocantar.resume.ui.components.models.ProfileHeaderComposable
import com.gocantar.resume.ui.theme.AppTheme

@Composable
fun Header(
    header: ProfileHeaderComposable,
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit = {},
    onClickLink: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colors.background)
            .padding(top = 32.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        ProfileHeader(header = header)
        Body(text = header.description, textAlign = TextAlign.Justify)
        Spacer(modifier = Modifier.height(16.dp))
        PrimaryButton(
            text = stringResource(id = R.string.label_download),
            icon = R.drawable.ic_cloud_download,
            onClick = onClickButton
        )
        Spacer(modifier = Modifier.height(8.dp))
        ButtonLink(
            text = stringResource(id = R.string.label_contact),
            icon = R.drawable.ic_contact,
            onClick = onClickLink
        )
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
                HeadLine5(text = stringResource(id = R.string.label_greeting))
                Subtitle(text = stringResource(id = R.string.label_i_am))
                Subtitle(text = "${header.firstName} ${header.secondName}")
            }
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = header.image),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    AppTheme {
        Header(header = Profile.value)
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
private fun HeaderPreviewDark() {
    AppTheme(darkTheme = true) {
        Header(header = Profile.value)
    }
}