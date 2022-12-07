package com.gocantar.resume.data.extensions

import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import org.junit.Test


class StringExtensionsTest {

    @Test
    fun `Given string to append a suffix When length is by default Then append 8 digits`() {
        val string = "foo"
        val result = string.appendAlphaNumericSuffix().replace("${string}_", "")
        assertEquals(8, result.length)
    }

    @Test
    fun `Given string to append a suffix When desire length is 5 Then append 5 digits`() {
        val string = "foo"
        val result = string
            .appendAlphaNumericSuffix(length = 5)
            .replace("${string}_", "")
        assertEquals(5, result.length)
    }

    @Test
    fun `Given same string to times to append a suffix Then should return different suffix`() {
        val string = "foo"
        assertNotEquals(
            string.appendAlphaNumericSuffix(),
            string.appendAlphaNumericSuffix()
        )
    }
}