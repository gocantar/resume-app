package com.gocantar.resume.data.handlers

import android.content.res.AssetManager
import java.io.InputStream
import javax.inject.Inject

class AssetsHandler (private val assets: AssetManager) {

    /**
     * Get document from the assets with the given file name
     *
     * @param file name of the document
     */
    fun open(file: String): InputStream {
        return assets.open(file)
    }
}