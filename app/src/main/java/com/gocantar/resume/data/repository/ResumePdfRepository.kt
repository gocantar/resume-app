package com.gocantar.resume.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.gocantar.resume.data.datasource.SharedPreferencesDataSource
import com.gocantar.resume.data.extensions.appendAlphaNumericSuffix
import com.gocantar.resume.data.handlers.AssetsHandler
import com.gocantar.resume.data.handlers.ContentHandler
import com.gocantar.resume.data.models.PdfUri

@RequiresApi(Build.VERSION_CODES.Q)
class ResumePdfRepository(
    private val preferences: SharedPreferencesDataSource,
    private val assets: AssetsHandler,
    private val content: ContentHandler
) {

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
        val file = baseFileName.appendAlphaNumericSuffix()
        val url = runCatching { content.save(file = file, data = assets.open(assetFileName)) }
        if (url.isSuccess) {
            preferences.set(SharedPreferencesDataSource.KEY_PDF_FILE, file)
        }
        return url
    }
}