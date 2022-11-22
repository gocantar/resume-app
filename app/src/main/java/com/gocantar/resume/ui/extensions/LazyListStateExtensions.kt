package com.gocantar.resume.ui.extensions

import androidx.compose.foundation.lazy.LazyListState
import kotlin.math.absoluteValue

fun LazyListState.offsetAlpha(maxOffset: Int): Float {
    val noScrollAlpha = 0.0F
    val offset = firstVisibleItemScrollOffset
        .absoluteValue.coerceIn(0, maxOffset)
        .takeIf { firstVisibleItemIndex == 0 }
        ?: maxOffset
    val calculatedAlpha = (offset.toFloat() / maxOffset.toFloat())
    return noScrollAlpha
        .takeIf { calculatedAlpha == noScrollAlpha }
        ?: calculatedAlpha.coerceIn(0.3F, 1F)
}