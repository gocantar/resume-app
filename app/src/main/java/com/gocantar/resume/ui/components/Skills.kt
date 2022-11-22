package com.gocantar.resume.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gocantar.resume.data.Skills
import com.gocantar.resume.ui.components.defaults.SkillsDefaults
import com.gocantar.resume.ui.components.models.SkillsComposable
import com.gocantar.resume.ui.components.models.SkillsPanelComposable
import com.gocantar.resume.ui.theme.AppTheme

@Composable
fun Skills(skills: SkillsComposable) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(MaterialTheme.colors.surface)
            .padding(SkillsDefaults.Padding),
        verticalArrangement = Arrangement.spacedBy(SkillsDefaults.Padding),
    ) {
        HeadLine5(text = skills.header)
        skills.items.forEachIndexed { index, skillsPanel ->
            SkillsPanel(skillsGroup = skillsPanel)
            if (index < skills.items.lastIndex) {
                Divider()
            }
        }
    }
}

@Composable
private fun SkillsPanel(
    skillsGroup: SkillsPanelComposable,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row {
            Icon(
                painter = painterResource(id = skillsGroup.icon),
                tint = MaterialTheme.colors.primary,
                contentDescription = null
            )
            Subtitle(
                text = skillsGroup.title,
                modifier = Modifier.padding(start = 8.dp),
                maxLines = 1
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        skillsGroup.skills.forEach { Body(text = "• $it") }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun SkillsPanelPreview() {
    AppTheme {
        Skills(
            skills = SkillsComposable(
                header = "Aptitudes",
                items = Skills.items
            )
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
private fun SkillsPanelPreviewDark() {
    AppTheme(darkTheme = true) {
        Skills(
            skills = SkillsComposable(
                header = "Aptitudes",
                items = Skills.items
            )
        )
    }
}