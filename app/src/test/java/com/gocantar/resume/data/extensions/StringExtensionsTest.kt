package com.gocantar.resume.data.extensions

import kotlin.test.assertNotEquals
import org.junit.Test


class StringExtensionsTest {

    @Test
    fun `Given same string to times to append a suffix Then should return different suffix`() {
        val string = "foo"
        val name = string.appendSuffix()
        Thread.sleep(1)
        val nameAfterDelay = string.appendSuffix()
        assertNotEquals(
            name,
            nameAfterDelay
        )
    }
}