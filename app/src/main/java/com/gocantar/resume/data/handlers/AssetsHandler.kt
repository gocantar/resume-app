package com.gocantar.resume.data.handlers

import android.content.res.AssetManager
import java.io.InputStream

class AssetsHandler(private val assets: AssetManager) {

    fun open(file: String): InputStream {
        return assets.open(file)
    }
}