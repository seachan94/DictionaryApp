package com.example.dictionaryapp.di

import com.example.dictionaryapp.ui.adapter.WordAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    @Singleton
    fun provideWordAdapter() : WordAdapter = WordAdapter()


}