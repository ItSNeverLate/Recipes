package com.example.composemvvmrecipeapp.presentation.ui.recipe

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composemvvmrecipeapp.domain.model.Recipe
import com.example.composemvvmrecipeapp.presentation.ui.STATE_KEY_RECIPE_ID
import com.example.composemvvmrecipeapp.repository.abstraction.RecipeRepository
import kotlinx.coroutines.launch

class RecipeViewModel
@ViewModelInject
constructor(
    private val repository: RecipeRepository,
    @Assisted private val savedState: SavedStateHandle
) : ViewModel() {

    private val recipeId = savedState.get<Int>(STATE_KEY_RECIPE_ID)

    val recipe: MutableState<Recipe?> = mutableStateOf(null)

    init {
        viewModelScope.launch {
            recipeId?.let { recipeId ->
                recipe.value = repository.getById(recipeId)
            }
        }
    }
}