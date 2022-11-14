package com.gocantar.resume.ui.extensions

import androidx.compose.foundation.ScrollState

fun ScrollState.toAlpha(max: Int): Float {
    val noScrollAlpha = 0.0F
    val calculatedAlpha = (this.value / max.toFloat())
    return noScrollAlpha
        .takeIf { calculatedAlpha == noScrollAlpha }
        ?: calculatedAlpha.coerceIn(0.3F, 1F)
}