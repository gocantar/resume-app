package com.gocantar.resume.data.datasource

import android.content.Context
import android.content.SharedPreferences
import com.gocantar.resume.BuildConfig

class SharedPreferencesDataSource(private val context: Context) {

    companion object {
        const val KEY_PDF_FILE = "pdf-file"
    }

    private val ID = "${BuildConfig.APPLICATION_ID}.storage"

    private val preferences: SharedPreferences
        get() = context.getSharedPreferences(ID, Context.MODE_PRIVATE)

    fun set(key: String, value: String) {
        preferences.edit().run {
            putString(key, value)
            commit()
        }
    }

    fun get(key: String): String? {
        return preferences.getString(key, null)
    }
}