package com.example.composemvvmrecipeapp.repository.abstraction

import com.example.composemvvmrecipeapp.domain.model.Recipe

interface RecipeRepository {

    suspend fun getAll(query: String, page: Int): List<Recipe>

    suspend fun getById(id: Int): Recipe
}