package com.example.composemvvmrecipeapp.repository.implementation

import com.example.composemvvmrecipeapp.data.network.AppService
import com.example.composemvvmrecipeapp.data.network.dto.RecipeDto
import com.example.composemvvmrecipeapp.domain.mapper.Mapper
import com.example.composemvvmrecipeapp.domain.model.Recipe
import com.example.composemvvmrecipeapp.repository.abstraction.RecipeRepository

class RecipeRepositoryImp(
    private val appService: AppService,
    private val dtoMapper: Mapper<Recipe, RecipeDto>
) : RecipeRepository {

    override suspend fun getAll(query: String, page: Int) =
        dtoMapper.toModelList(appService.getAll(query, page).recipes)

    override suspend fun getById(id: Int) =
        dtoMapper.toModel(appService.getById(id))
}