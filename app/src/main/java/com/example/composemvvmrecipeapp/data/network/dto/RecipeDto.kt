package com.example.composemvvmrecipeapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class RecipeDto(
    @SerializedName("pk")
    val id: Int,
    val title: String,
    val publisher: String? = null,
    @SerializedName("featured_image")
    val featuredImage: String? = null,
    val rating: Int? = null,
    @SerializedName("source_url")
    val sourceUrl: String? = null,
    val description: String? = null,
    @SerializedName("cooking_instructions")
    val cookingInstructions: String? = null,
    val ingredients: List<String>? = null,
    @SerializedName("date_added")
    val dateAdded: String? = null,
    @SerializedName("date_updated")
    val dateUpdated: String? = null
)