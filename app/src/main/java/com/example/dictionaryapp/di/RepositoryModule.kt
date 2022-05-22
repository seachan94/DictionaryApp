package com.example.dictionaryapp.di

import com.nocompany.data.repository.NaverWordRepositoryImpl
import com.nocompany.domain.repository.NaverWordRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindNaverWordRepository(naverWordRepositoryImpl: NaverWordRepositoryImpl) :NaverWordRepository

}