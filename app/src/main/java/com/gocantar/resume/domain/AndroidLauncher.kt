package com.gocantar.resume.domain

import android.content.Context
import android.content.Intent
import com.gocantar.resume.domain.models.PdfUri


class AndroidLauncher(private val context: Context) {

    fun openPdf(uri: PdfUri) {
        val intent = Intent(Intent.ACTION_VIEW)
        //intent.setDataAndType(Uri.fromFile(file), "application/pdf");
        //intent.setDataAndType(Uri.fromFile(file), "application/pdf");
        intent.setDataAndType(uri.value, "application/pdf")
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        context.startActivity(intent)
    }
}