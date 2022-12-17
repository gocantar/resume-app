package com.gocantar.resume.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gocantar.resume.domain.usecase.DownloadPdfUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ResumeViewModel @Inject constructor(
    private val downloadPdfUseCase: DownloadPdfUseCase
) : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.Q)
    fun downloadPdf() {
        viewModelScope.launch {
            downloadPdfUseCase.invoke()
        }
    }
}