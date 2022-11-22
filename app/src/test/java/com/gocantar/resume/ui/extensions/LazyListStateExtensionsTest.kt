package com.gocantar.resume.ui.extensions

import androidx.compose.foundation.lazy.LazyListState
import kotlin.test.assertEquals
import org.junit.Test

class LazyListStateExtensionsTest {

    @Test
    fun `Given scroll of 0 pixel When max scroll is 100 Then should return 0`() {
        val scrollState = LazyListState(firstVisibleItemScrollOffset = 0)
        assertEquals(0F, scrollState.offsetAlpha(maxOffset = 100))
    }

    @Test
    fun `Given scroll of 29 pixel When max scroll is 100 Then should return 0`() {
        val scrollState = LazyListState(firstVisibleItemScrollOffset = 29)
        assertEquals(0.3F, scrollState.offsetAlpha(maxOffset = 100))
    }

    @Test
    fun `Given scroll of 30 pixel When max scroll is 100 Then should return 0_3`() {
        val scrollState = LazyListState(firstVisibleItemScrollOffset = 30)
        assertEquals(0.3F, scrollState.offsetAlpha(maxOffset = 100))
    }

    @Test
    fun `Given scroll of 99 pixel When max scroll is 100 Then should return 0_99`() {
        val scrollState = LazyListState(firstVisibleItemScrollOffset = 99)
        assertEquals(0.99F, scrollState.offsetAlpha(maxOffset = 100))
    }

    @Test
    fun `Given scroll of 100 pixel When max scroll is 100 Then should return 1`() {
        val scrollState = LazyListState(firstVisibleItemScrollOffset = 100)
        assertEquals(1F, scrollState.offsetAlpha(maxOffset = 100))
    }

    @Test
    fun `Given scroll of 110 pixel When max scroll is 100 Then should return 1`() {
        val scrollState = LazyListState(firstVisibleItemScrollOffset = 110)
        assertEquals(1F, scrollState.offsetAlpha(maxOffset = 100))
    }

    @Test
    fun `Given scroll of 99 pixel When first item is not visible Then should return 1`() {
        val scrollState = LazyListState(
            firstVisibleItemIndex = 1,
            firstVisibleItemScrollOffset = 99
        )
        assertEquals(1F, scrollState.offsetAlpha(maxOffset = 100))
    }
}