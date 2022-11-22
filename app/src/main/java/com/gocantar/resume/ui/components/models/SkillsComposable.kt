package com.gocantar.resume.ui.components.models

import androidx.annotation.DrawableRes

data class SkillsComposable(
    val header: String,
    val items: List<SkillsPanelComposable>
)

data class SkillsPanelComposable(
    @DrawableRes
    val icon: Int,
    val title: String,
    val skills: List<String>
)
