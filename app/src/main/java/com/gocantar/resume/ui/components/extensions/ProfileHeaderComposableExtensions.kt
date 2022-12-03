package com.gocantar.resume.ui.components.extensions

import com.gocantar.resume.ui.components.models.ProfileHeaderComposable

fun ProfileHeaderComposable.toHeaderName(): String {
    return when {
        firstName.isBlank() && secondName.isBlank() -> String()
        firstName.isBlank() -> secondName
        secondName.isBlank() -> firstName
        else -> "$firstName ${secondName[0]}."
    }
}