package com.gocantar.resume.di

import android.content.Context
import com.gocantar.resume.data.datasource.SharedPreferencesDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
private object PreferencesModule {

    @Provides
    fun providePreferences(@ApplicationContext context: Context): SharedPreferencesDataSource {
        return SharedPreferencesDataSource(context)
    }
}