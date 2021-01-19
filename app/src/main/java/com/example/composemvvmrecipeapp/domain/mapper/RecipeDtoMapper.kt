package com.example.composemvvmrecipeapp.domain.mapper

import com.example.composemvvmrecipeapp.data.network.dto.RecipeDto
import com.example.composemvvmrecipeapp.domain.model.Recipe
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

class RecipeDtoMapper : Mapper<Recipe, RecipeDto> {

    override fun toModel(dto: RecipeDto) = Recipe(
        id = dto.id,
        title = dto.title,
        publisher = dto.publisher,
        featuredImage = dto.featuredImage,
        rating = dto.rating,
        sourceUrl = dto.sourceUrl,
        description = dto.description,
        cookingInstructions = dto.cookingInstructions,
        ingredients = dto.ingredients,
        dateAdded = dto.dateAdded,
        dateUpdated = dto.dateUpdated
    )

    override fun fromModel(model: Recipe) = RecipeDto(
        id = model.id,
        title = model.title,
        publisher = model.publisher,
        featuredImage = model.featuredImage,
        rating = model.rating,
        sourceUrl = model.sourceUrl,
        description = model.description,
        cookingInstructions = model.cookingInstructions,
        ingredients = model.ingredients,
        dateAdded = model.dateAdded,
        dateUpdated = model.dateUpdated
    )
}