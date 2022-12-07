package com.gocantar.resume.data.extensions

private val ALPHA_NUMERIC_CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"

fun String.appendAlphaNumericSuffix(length: Int = 8): String {
    val suffix =  (1..length)
        .map { ALPHA_NUMERIC_CHAR_SET.random() }
        .joinToString("")
    return "${this}_$suffix"
}