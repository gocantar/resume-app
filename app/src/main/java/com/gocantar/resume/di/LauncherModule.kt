package com.gocantar.resume.di

import android.content.Context
import com.gocantar.resume.domain.AndroidLauncher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
private object LauncherModule {

    @Provides
    fun provideAndroidLauncher(@ApplicationContext context: Context): AndroidLauncher {
        return AndroidLauncher(context)
    }
}