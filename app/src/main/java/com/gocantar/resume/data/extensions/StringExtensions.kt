package com.gocantar.resume.data.extensions


fun String.appendSuffix(): String {
    return "${this}_${System.currentTimeMillis()}"
}