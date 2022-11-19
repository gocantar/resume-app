package com.gocantar.resume.ui.components.models.extensions

import com.gocantar.resume.ui.components.models.SkillComposable

val SkillComposable.valueProgress: Float
    get() = (value / 10F).coerceIn(0F, 1F)