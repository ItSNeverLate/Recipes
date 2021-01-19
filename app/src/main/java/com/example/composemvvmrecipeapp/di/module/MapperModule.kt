package com.example.composemvvmrecipeapp.di.module

import com.example.composemvvmrecipeapp.domain.mapper.RecipeDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object MapperModule {

    @Singleton
    @Provides
    fun provideRecipeDtoMapper() =
        RecipeDtoMapper()
}