package com.example.dictionaryapp.di.network

import com.example.dictionaryapp.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.nocompany.data.api.retrofit.NetworkResponseAdapterFactory
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
object KaKaoNetworkModule {
    @Provides
    @Singleton
    @CommonNetworkModule.KaKaoApi
    fun providesInterceptor() = Interceptor {
        it.proceed(
            it.request().newBuilder()
                .build()
        )
    }

    @Singleton
    @Provides
    @CommonNetworkModule.KaKaoApi
    fun providesOkHttpClient(
        @CommonNetworkModule.KaKaoApi interceptor: Interceptor,
    ) = OkHttpClient.Builder().apply {
        hostnameVerifier { _, _ -> true }
        addInterceptor(interceptor)
        addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        connectTimeout(15, TimeUnit.SECONDS)
        writeTimeout(15, TimeUnit.SECONDS)
        readTimeout(15, TimeUnit.SECONDS)
    }.build()

    @Singleton
    @Provides
    @CommonNetworkModule.KaKaoApi
    fun provideRetrofit(
        @CommonNetworkModule.KaKaoApi okHttpClient: OkHttpClient,
        json: Json,
    ): Retrofit =
        Retrofit.Builder().apply {
            addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            addCallAdapterFactory(NetworkResponseAdapterFactory())
            baseUrl("baseUrl")
            client(okHttpClient)
        }.build()
}