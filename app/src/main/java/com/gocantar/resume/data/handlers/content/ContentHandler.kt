package com.gocantar.resume.data.handlers.content

import com.gocantar.resume.domain.models.PdfUri
import java.io.InputStream

interface ContentHandler {

    /**
     * Find document in the shared storage with the given file name
     *
     * @param file name of the document
     */
    fun find(file: String): PdfUri

    /**
     * Save document in the shared storage with the given file name
     *
     * @param file name of the document
     * @param data file to be saved
     */
    fun save(file: String, data: InputStream): PdfUri
}
