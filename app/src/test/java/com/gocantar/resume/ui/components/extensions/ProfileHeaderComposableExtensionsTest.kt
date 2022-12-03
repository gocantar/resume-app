package com.gocantar.resume.ui.components.extensions

import com.gocantar.resume.ui.components.models.ProfileHeaderComposable
import kotlin.test.assertEquals
import org.junit.Test

class ProfileHeaderComposableExtensionsTest {

    @Test
    fun `Given profile When has first and second name Then should return name formatted`() {
        val profile = ProfileHeaderComposable(
            image = 0,
            firstName = "Peter",
            secondName = "Parker",
            description = String()
        )
        assertEquals("Peter P.", profile.toHeaderName())
    }

    @Test
    fun `Given profile When has only first name Then should return the first name formatted`() {
        val profile = ProfileHeaderComposable(
            image = 0,
            firstName = "Peter",
            secondName = " ",
            description = String()
        )
        assertEquals("Peter", profile.toHeaderName())
    }

    @Test
    fun `Given profile When has only second name Then should return the second name formatted`() {
        val profile = ProfileHeaderComposable(
            image = 0,
            firstName = String(),
            secondName = "Parker",
            description = String()
        )
        assertEquals("Parker", profile.toHeaderName())
    }

    @Test
    fun `Given profile When first and second name are empty Then should return empty name`() {
        val profile = ProfileHeaderComposable(
            image = 0,
            firstName = " ",
            secondName = String(),
            description = String()
        )
        assertEquals(String(), profile.toHeaderName())
    }
}