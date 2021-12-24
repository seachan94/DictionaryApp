package com.example.dictionaryapp.di

import com.example.dictionaryapp.data.remote.repository.DictionaryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideRetrofit() : DictionaryApi =
        Retrofit.Builder().apply {
            baseUrl("https://stdict.korean.go.kr/api/")
            addConverterFactory(GsonConverterFactory.create())
        }.build()
            .create(DictionaryApi::class.java)

}