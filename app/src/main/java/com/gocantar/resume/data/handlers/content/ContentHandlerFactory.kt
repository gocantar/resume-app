package com.gocantar.resume.data.handlers.content

import android.content.Context
import android.os.Build

class ContentHandlerFactory(private val context: Context) {

    fun get(): ContentHandler {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            DefaultContentHandler(context)
        } else {
            return LegacyContentHandler()
        }
    }
}