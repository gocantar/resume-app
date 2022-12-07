package com.gocantar.resume.data.handlers

import android.content.ContentResolver
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import com.gocantar.resume.data.models.PdfUri
import java.io.InputStream

@RequiresApi(Build.VERSION_CODES.Q)
class ContentHandler(
    private val context: Context,
    private val contentValues: ContentValues
) {

    private val content: ContentResolver
        get() = context.contentResolver

    fun find(file: String): PdfUri {
        val id = content.findIdBy(displayName = file)
        return PdfUri(context.buildDocumentUrlFrom(id = id))
    }

    private fun ContentResolver.findIdBy(displayName: String): String {
        var cursor: Cursor? = null
        try {
            cursor = query(
                MediaStore.Downloads.EXTERNAL_CONTENT_URI,
                arrayOf(MediaStore.Downloads._ID),
                "${MediaStore.Downloads.DISPLAY_NAME}=$displayName",
                null,
                null
            ) ?: throw Exception("Invalid content resolver query")
            return cursor.getDocumentId()
        } catch (exception: Exception) {
            throw exception
        } finally {
            cursor?.close()
        }
    }

    private fun Cursor.getDocumentId(): String {
        if (!moveToNext()) throw Exception("File not found")
        val columIndex = getColumnIndex(MediaStore.Downloads._ID)
            .takeIf { it != -1 }
            ?: throw Exception("File not found")
        return getLong(columIndex).toString()
    }

    private fun Context.buildDocumentUrlFrom(id: String): Uri {
        return MediaStore.getDocumentUri(this, MediaStore.Downloads.EXTERNAL_CONTENT_URI)
            ?.buildUpon()
            ?.appendPath(id)
            ?.build()
            ?: throw Exception("Document Uri error")
    }

    fun save(file: String, data: InputStream): PdfUri {
        val url = content.insert(file)
        data.copyTo(url)
        return PdfUri(value = url)
    }

    private fun ContentResolver.insert(file: String): Uri {
        return insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues.name(file))
            ?: throw Exception("Uri can not be null")
    }

    private fun ContentValues.name(value: String): ContentValues {
        put(MediaStore.MediaColumns.DISPLAY_NAME, value)
        return this
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