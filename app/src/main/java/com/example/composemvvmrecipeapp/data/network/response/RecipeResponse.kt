package com.example.composemvvmrecipeapp.data.network.response

import com.example.composemvvmrecipeapp.data.network.dto.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    val count: Int,
    val next: String? = null,
    val previous: String? = null,
    @SerializedName("results")
    val recipes: List<RecipeDto>
)