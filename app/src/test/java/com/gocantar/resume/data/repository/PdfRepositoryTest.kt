package com.gocantar.resume.data.repository

import com.gocantar.resume.data.datasource.SharedPreferencesDataSource
import com.gocantar.resume.data.extensions.appendSuffix
import com.gocantar.resume.data.handlers.AssetsHandler
import com.gocantar.resume.data.handlers.content.ContentHandler
import com.gocantar.resume.data.handlers.content.ContentHandlerFactory
import com.gocantar.resume.data.handlers.content.DefaultContentHandler
import com.gocantar.resume.domain.models.PdfUri
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import io.mockk.verify
import java.io.InputStream
import kotlin.test.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

internal class PdfRepositoryTest {

    private val preferences = mockk<SharedPreferencesDataSource>(relaxed = true)
    private val assets = mockk<AssetsHandler>(relaxed = true)
    private val contentFactory = mockk<ContentHandlerFactory>()
    private val content = mockk<ContentHandler>(relaxed = true)

    private lateinit var repository: PdfRepository

    @Before
    fun setUp() {
        mockkStatic("com.gocantar.resume.data.extensions.StringExtensionsKt")
        every { contentFactory.get() } returns content
        repository = PdfRepository(preferences, assets, contentFactory)
    }

    @Test
    fun `Given Pdf Url request When it is first time Then should save it in the storage`() {
        val input = mockk<InputStream>(relaxed = true)
        val pdfUri = mockk<PdfUri>(relaxed = true)
        every { preferences.get("pdf-file") } returns null
        every { assets.open("cv_file.pdf")  } returns input
        every { "Gonzalo_Cantarero".appendSuffix() } returns "name_abcdefgh"
        every { content.save("name_abcdefgh", input) } returns pdfUri
        val result = repository.get()
        verify { preferences.set("pdf-file", "name_abcdefgh") }
        assertEquals(Result.success(pdfUri), result)
    }

    @Test
    fun `Given Pdf Url request When error occurs opening assets Then should return an Error`() {
        val exception = mockk<Exception>(relaxed = true)
        every { preferences.get("pdf-file") } returns null
        every { assets.open("cv_file.pdf")  } throws exception
        val result = repository.get()
        verify(inverse = true) { preferences.set(any(), any()) }
        assertEquals(Result.failure(exception), result)
    }

    @Test
    fun `Given Pdf Url request When error occurs saving content Then should return an Error`() {
        val exception = mockk<Exception>(relaxed = true)
        val input = mockk<InputStream>(relaxed = true)
        every { preferences.get("pdf-file") } returns null
        every { assets.open("cv_file.pdf")  } returns input
        every { "Gonzalo_Cantarero".appendSuffix() } returns "name_abcdefgh"
        every { content.save("name_abcdefgh", input) } throws exception
        val result = repository.get()
        verify(inverse = true) { preferences.set(any(), any()) }
        assertEquals(Result.failure(exception), result)
    }

    @Test
    fun `Given Pdf Url request When it found in the storage Then should return the Uri`() {
        val pdfUri = mockk<PdfUri>(relaxed = true)
        every { preferences.get("pdf-file") } returns "name_abcdefgh"
        every { "Gonzalo_Cantarero".appendSuffix() } returns "name_abcdefgh"
        every { content.find("name_abcdefgh") } returns pdfUri
        val result = repository.get()
        verify(inverse = true) { preferences.set(any(), any()) }
        assertEquals(Result.success(pdfUri), result)
    }

    @Test
    fun `Given Pdf Url request When it not found in storage Then should return new saved Uri`() {
        val input = mockk<InputStream>(relaxed = true)
        val pdfUri = mockk<PdfUri>(relaxed = true)
        every { preferences.get("pdf-file") } returns "name_abcdefgh"
        every { content.find("name_abcdefgh") } throws Exception()
        every { assets.open("cv_file.pdf")  } returns input
        every { "Gonzalo_Cantarero".appendSuffix() } returns "name_abcdefgh"
        every { content.save("name_abcdefgh", input) } returns pdfUri
        val result = repository.get()
        verify { preferences.set("pdf-file", "name_abcdefgh") }
        assertEquals(Result.success(pdfUri), result)
    }

    @After
    fun tearDown() {
        unmockkStatic("com.gocantar.resume.data.extensions.StringExtensionsKt")
    }
}