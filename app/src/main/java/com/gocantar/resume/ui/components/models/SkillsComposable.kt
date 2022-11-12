package com.gocantar.resume.ui.components.models

import androidx.annotation.DrawableRes

data class SkillsComposable(
    val header: String,
    val items: List<SkillComposable>
)

data class SkillComposable(
    val title: String,
    val description: String?,
    @DrawableRes val icon: Int
)