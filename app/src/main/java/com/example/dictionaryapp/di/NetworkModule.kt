package com.example.dictionaryapp.di

import com.example.dictionaryapp.data.remote.repository.DictionaryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit =
        Retrofit.Builder().apply {
            baseUrl("https://api.dictionaryapi.dev/")
            addConverterFactory(GsonConverterFactory.create())
        }.build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): DictionaryApi =
        retrofit.create(DictionaryApi::class.java)

}