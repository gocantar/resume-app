package com.gocantar.resume.data.repository

import com.gocantar.resume.data.datasource.SharedPreferencesDataSource
import com.gocantar.resume.data.extensions.appendSuffix
import com.gocantar.resume.data.handlers.AssetsHandler
import com.gocantar.resume.data.handlers.content.ContentHandler
import com.gocantar.resume.data.handlers.content.ContentHandlerFactory
import com.gocantar.resume.domain.models.PdfUri
import javax.inject.Inject

class PdfRepository @Inject constructor(
    private val preferences: SharedPreferencesDataSource,
    private val assets: AssetsHandler,
    contentFactory: ContentHandlerFactory
) {

    private val content: ContentHandler by lazy { contentFactory.get() }

    fun get(): Result<PdfUri?> {
        val storeFileName = preferences.get(SharedPreferencesDataSource.KEY_PDF_FILE)
        return storeFileName?.let { file ->
            runCatching { content.find(file = file) }
                .takeIf { it.isSuccess }
                ?: saveNewFile()
        } ?: saveNewFile()
    }

    private fun saveNewFile(): Result<PdfUri> {
        val assetFileName = "cv_file.pdf"
        val baseFileName = "Gonzalo_Cantarero"
        val file = baseFileName.appendSuffix()
        val url = runCatching { content.save(file = file, data = assets.open(assetFileName)) }
        if (url.isSuccess) {
            preferences.set(SharedPreferencesDataSource.KEY_PDF_FILE, file)
        }
        return url
    }
}