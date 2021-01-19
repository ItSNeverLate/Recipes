package com.example.composemvvmrecipeapp.domain.model

data class Recipe(
    val id: Int,
    val title: String,
    val publisher: String? = null,
    val featuredImage: String? = null,
    val rating: Int? = null,
    val sourceUrl: String? = null,
    val description: String? = null,
    val cookingInstructions: String? = null,
    val ingredients: List<String>? = null,
    val dateAdded: String? = null,
    val dateUpdated: String? = null
)