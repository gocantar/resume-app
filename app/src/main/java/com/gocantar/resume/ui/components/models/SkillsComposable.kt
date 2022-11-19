package com.gocantar.resume.ui.components.models

import androidx.annotation.DrawableRes

data class SkillsComposable(
    val header: String,
    val items: List<SkillComposable>
)

data class SkillComposable(
    @DrawableRes
    val icon: Int,
    val title: String,
    val value: Int
)