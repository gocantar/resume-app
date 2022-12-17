package com.gocantar.resume.data.handlers.content

import android.content.ContentResolver
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import com.gocantar.resume.domain.models.PdfUri
import java.io.InputStream

@RequiresApi(Build.VERSION_CODES.Q)
class DefaultContentHandler(private val context: Context): ContentHandler {

    private val content: ContentResolver
        get() = context.contentResolver


    override fun find(file: String): PdfUri {
        val url = content.findUrlBy(displayName = file)
        return PdfUri(url)
    }

    private fun ContentResolver.findUrlBy(displayName: String): Uri {
        var cursor: Cursor? = null
        try {
            cursor = query(
                MediaStore.Downloads.EXTERNAL_CONTENT_URI,
                arrayOf(MediaStore.Downloads._ID),
                """${MediaStore.Downloads.DISPLAY_NAME}="$displayName.pdf"""",
                null,
                null
            ) ?: throw Exception("Invalid content resolver query")
            if (!cursor.moveToFirst()) throw Exception("File not found")
            val columIndex = cursor.getColumnIndex(MediaStore.Downloads._ID)
                .takeIf { it != -1 }
                ?: throw Exception("File not found")
            return MediaStore.Downloads.EXTERNAL_CONTENT_URI
                .buildUpon()
                .appendPath(cursor.getString(columIndex))
                .build()
        } finally {
            cursor?.close()
        }
    }

    override fun save(file: String, data: InputStream): PdfUri {
        val url = content.insert(file)
        data.copyTo(url)
        return PdfUri(value = url)
    }

    private fun ContentResolver.insert(file: String): Uri {
        val contentValues = ContentValues().apply {
            put(MediaStore.Downloads.DISPLAY_NAME, file)
            put(MediaStore.Downloads.MIME_TYPE, "application/pdf")
            put(MediaStore.Downloads.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
        }
        return insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)
            ?: throw Exception("Uri can not be null")
    }

    private fun InputStream.copyTo(url: Uri) {
        use { input ->
            content.openOutputStream(url).use { output ->
                output ?: throw Exception("OutputStream can not be null")
                input.copyTo(output, DEFAULT_BUFFER_SIZE)
            }
        }
    }
}