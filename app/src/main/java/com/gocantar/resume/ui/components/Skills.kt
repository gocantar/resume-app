package com.gocantar.resume.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gocantar.resume.data.Skills
import com.gocantar.resume.ui.components.defaults.SkillsDefaults
import com.gocantar.resume.ui.components.models.SkillComposable
import com.gocantar.resume.ui.components.models.SkillsComposable
import com.gocantar.resume.ui.components.models.extensions.valueProgress
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
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(SkillsDefaults.Padding)
    ) {
        val modifier = if (skills.count() != SkillsDefaults.ColumnsCount) {
            Modifier
                .fillMaxWidth(1F / SkillsDefaults.ColumnsCount)
                .padding(end = SkillsDefaults.Padding / 2)
        } else {
            Modifier.weight(1F)
        }
        skills.forEach { skill -> SkillCard(modifier = modifier, skill = skill) }
    }
}

@Composable
private fun SkillCard(
    skill: SkillComposable,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxHeight(),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier.padding(SkillsDefaults.Padding)
        ) {
            Icon(
                painter = painterResource(id = skill.icon),
                tint = MaterialTheme.colors.onBackground,
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(8.dp))
            Subtitle(text = skill.title, maxLines = 2)
            Spacer(modifier = Modifier.size(8.dp))
            SkillProgressIndicator(skill = skill)
        }
    }
}

@Composable
fun SkillProgressIndicator(
    skill: SkillComposable,
    modifier: Modifier = Modifier
) {
    val state = remember { mutableStateOf(0F) }
    val animation = animateFloatAsState(
        targetValue = state.value,
        animationSpec = tween(1_000)
    )
    Box(
        modifier = Modifier.fillMaxHeight(),
        contentAlignment = Alignment.BottomStart
    ) {
        LinearProgressIndicator(
            progress = animation.value,
            modifier = modifier
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp))
        )
    }
    LaunchedEffect(key1 = skill) {
        state.value = skill.valueProgress
    }
}

@Preview(showBackground = true)
@Composable
private fun SkillPreview() {
    AppTheme {
        Skills(
            skills = SkillsComposable(
                header = "Aptitudes Técnicas",
                items = Skills.Hard.items
            )
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
private fun SkillPreviewDark() {
    AppTheme(darkTheme = true) {
        Skills(
            skills = SkillsComposable(
                header = "Aptitudes Técnicas",
                items = Skills.Hard.items
            )
        )
    }
}