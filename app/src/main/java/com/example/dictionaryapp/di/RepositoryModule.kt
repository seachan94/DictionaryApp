package com.example.dictionaryapp.di

import com.example.dictionaryapp.data.remote.repository.DictionaryApi
import com.example.dictionaryapp.data.remote.repository.WordInfoRepository
import com.example.dictionaryapp.data.remote.repository.WordRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideWordRepository(api : DictionaryApi) : WordInfoRepository{
        return WordRepositoryImpl(api)
    }

}