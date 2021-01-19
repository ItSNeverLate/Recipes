package com.example.composemvvmrecipeapp.di.module

import com.example.composemvvmrecipeapp.data.network.AppService
import com.example.composemvvmrecipeapp.data.network.dto.RecipeDto
import com.example.composemvvmrecipeapp.domain.mapper.Mapper
import com.example.composemvvmrecipeapp.domain.mapper.RecipeDtoMapper
import com.example.composemvvmrecipeapp.domain.model.Recipe
import com.example.composemvvmrecipeapp.repository.abstraction.RecipeRepository
import com.example.composemvvmrecipeapp.repository.implementation.RecipeRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        appService: AppService,
        dtoMapper: RecipeDtoMapper
    ) = RecipeRepositoryImp(appService, dtoMapper) as RecipeRepository
}