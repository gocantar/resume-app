package com.gocantar.resume.domain.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.gocantar.resume.data.repository.PdfRepository
import com.gocantar.resume.domain.AndroidLauncher
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DownloadPdfUseCase @Inject constructor(
    private val repository: PdfRepository,
    private val launcher: AndroidLauncher
) {

    @RequiresApi(Build.VERSION_CODES.Q)
    suspend operator fun invoke() {
        val uri = withContext(Dispatchers.IO) {
            repository.get()
        }
        uri.getOrNull()?.let { launcher.openPdf(it) }
    }
}