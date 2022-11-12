package com.gocantar.resume.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gocantar.resume.R
import com.gocantar.resume.ui.components.defaults.SkillsDefaults
import com.gocantar.resume.ui.components.models.SkillComposable
import com.gocantar.resume.ui.components.models.SkillsComposable
import com.gocantar.resume.ui.theme.AppTheme

@Composable
fun Skills(skills: SkillsComposable) {
    val groupedSkills = skills.items.chunked(SkillsDefaults.ColumnsCount)
    Column(
        modifier = Modifier.padding(SkillsDefaults.Padding),
        verticalArrangement = Arrangement.spacedBy(SkillsDefaults.Padding)
    ) {
        HeadLine5(text = skills.header)
        groupedSkills.forEach { SkillsRow(skills = it) }
    }
}

@Composable
private fun SkillsRow(skills: List<SkillComposable>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(SkillsDefaults.Padding)
    ) {
        val modifier = if (skills.count() != SkillsDefaults.ColumnsCount) {
            Modifier
                .fillMaxWidth(1F / SkillsDefaults.ColumnsCount)
                .padding(end = SkillsDefaults.Padding / 2)
        } else { Modifier.weight(1F) }
        skills.forEach { skill -> Skill(modifier = modifier, skill = skill) }
    }
}

@Composable
private fun Skill(
    skill: SkillComposable,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        elevation = 0.dp
    ) {
        Column(modifier = Modifier.padding(SkillsDefaults.Padding)) {
            Icon(
                painter = painterResource(id = skill.icon),
                tint = MaterialTheme.colors.primary,
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(8.dp))
            Subtitle(text = skill.title, maxLines = 2)
            Spacer(modifier = Modifier.size(8.dp))
            Body(text = skill.description)
            // TODO add empty Text() with IntrinsicHeight
            // Text(text = "")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SkillPreview() {
    AppTheme {
        Skills(
            skills = SkillsComposable(
                header = "Soft Skills",
                items = listOf(
                    SkillComposable(
                        title = "1 Small title ",
                        description = "1 Small description",
                        icon = R.drawable.ic_cloud_download
                    ),
                    SkillComposable(
                        title = "2 Medium long title",
                        description = "2 Medium long description",
                        icon = R.drawable.ic_cloud_download
                    ),
                    SkillComposable(
                        title = "3 Small title",
                        description = "3 Small description",
                        icon = R.drawable.ic_cloud_download
                    ),
                    SkillComposable(
                        title = "4 Large very long title more than two lines",
                        description = "4 Large very long description with more than three lines",
                        icon = R.drawable.ic_cloud_download
                    ),
                    SkillComposable(
                        title = "5 Small title",
                        description = "5 Small description",
                        icon = R.drawable.ic_cloud_download
                    ),
                )
            )
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun SkillPreviewDark() {
    AppTheme(darkTheme = true) {
        Skills(
            skills = SkillsComposable(
                header = "Soft Skills",
                items = listOf(
                    SkillComposable(
                        title = "1 Small title ",
                        description = "1 Small description",
                        icon = R.drawable.ic_cloud_download
                    ),
                    SkillComposable(
                        title = "2 Medium long title",
                        description = "2 Medium long description",
                        icon = R.drawable.ic_cloud_download
                    ),
                    SkillComposable(
                        title = "3 Small title",
                        description = "3 Small description",
                        icon = R.drawable.ic_cloud_download
                    ),
                    SkillComposable(
                        title = "4 Large very long title more than two lines",
                        description = "4 Large very long description with more than three lines",
                        icon = R.drawable.ic_cloud_download
                    ),
                    SkillComposable(
                        title = "5 Small title",
                        description = "5 Small description",
                        icon = R.drawable.ic_cloud_download
                    )
                )
            )
        )
    }
}