package com.example.dictionaryapp.di

import com.example.dictionaryapp.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.nocompany.data.api.WordApi
import com.nocompany.data.api.retrofit.NetworkResponseAdapterFactory
import com.nocompany.data.repository.NaverWordRepositoryImpl
import com.nocompany.domain.repository.NaverWordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesInterceptor() = Interceptor{
        it.proceed(
            it.request().newBuilder()
                .addHeader("X-Naver-Client-Id", BuildConfig.NaverApiClientId)
                .addHeader("X-Naver-Client-Secret",BuildConfig.NaverApiClientSecrete)
                .build()
        )
    }
    @Singleton
    @Provides
    fun providesOkHttpClient(interceptor: Interceptor) = OkHttpClient.Builder().apply {
        hostnameVerifier { _, _ -> true }
        addInterceptor(interceptor)
        addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        connectTimeout(15, TimeUnit.SECONDS)
        writeTimeout(15, TimeUnit.SECONDS)
        readTimeout(15, TimeUnit.SECONDS)
    }.build()

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

    
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, json: Json): Retrofit =
        Retrofit.Builder().apply {
            addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            addCallAdapterFactory(NetworkResponseAdapterFactory())
            baseUrl("https://openapi.naver.com")
            client(okHttpClient)
        }.build()

    @Singleton
    @Provides
    fun providesWordApi(retrofit: Retrofit) =
        retrofit.create(WordApi::class.java)


}