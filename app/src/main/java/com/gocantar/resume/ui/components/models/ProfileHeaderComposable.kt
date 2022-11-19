package com.gocantar.resume.ui.components.models

import androidx.annotation.DrawableRes

data class ProfileHeaderComposable(
    @DrawableRes
    val image: Int,
    val firstName: String,
    val secondName: String,
    val description: String
)