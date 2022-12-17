package com.gocantar.resume.data.handlers.content

import com.gocantar.resume.domain.models.PdfUri
import java.io.InputStream

class LegacyContentHandler: ContentHandler {

    override fun find(file: String): PdfUri {
        TODO("Not yet implemented")
    }

    override fun save(file: String, data: InputStream): PdfUri {
        TODO("Not yet implemented")
    }
}