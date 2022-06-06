package com.example.dictionaryapp.di.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommonNetworkModule {

    @Provides
    @Singleton
    fun provideConverterFactory(): Json {
        return Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
            encodeDefaults = true
            isLenient = true
        }
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class KaKaoApi

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class NaverApi
}