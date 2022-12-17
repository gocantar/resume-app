package com.gocantar.resume.di

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.gocantar.resume.data.handlers.AssetsHandler
import com.gocantar.resume.data.handlers.content.ContentHandlerFactory
import com.gocantar.resume.data.handlers.content.DefaultContentHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
private object HandlersModule {

    @Provides
    fun provideAssetsHandler(@ApplicationContext context: Context): AssetsHandler {
        return AssetsHandler(context.assets)
    }

    @Provides
    fun provideContentHandler(@ApplicationContext context: Context): ContentHandlerFactory {
        return ContentHandlerFactory(context = context)
    }
}