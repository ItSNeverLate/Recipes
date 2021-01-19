package com.example.composemvvmrecipeapp.di.module

import com.example.composemvvmrecipeapp.data.network.AppService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppService(retrofit: Retrofit) =
        retrofit.create(AppService::class.java)

    @Singleton
    @Provides
    // For implement later
    fun provideAppDatabase() = null
}