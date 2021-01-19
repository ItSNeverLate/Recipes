package com.example.composemvvmrecipeapp.presentation.ui.recipelist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composemvvmrecipeapp.domain.model.Recipe
import com.example.composemvvmrecipeapp.repository.abstraction.RecipeRepository
import kotlinx.coroutines.launch

const val PAGE_SIZE = 30
const val STATE_KEY_QUERY = "quey"

class RecipeListViewModel
@ViewModelInject
constructor(
    private val repository: RecipeRepository,
    @Assisted private val savedState: SavedStateHandle
) : ViewModel() {

    val loading = mutableStateOf(false)

    val query = mutableStateOf(savedState.get(STATE_KEY_QUERY) ?: "")

    private var currentPage = 0

    var loadingPage = 1

    val recipes: MutableState<List<Recipe>> = mutableStateOf(listOf())

    var chipsScrollPosition = 0f

    init {
        search(true)

    }

    fun onSearchClicked() {
        search(true)
    }

    fun onEndOfListHandle() {
        if (loadingPage == currentPage) {
            loadingPage++
            search(false)
        }
    }

    private fun search(isNewSearch: Boolean) {
        viewModelScope.launch {
            if (isNewSearch) {
                currentPage = 0
                loadingPage = 1
                recipes.value = listOf()
            }
            loading.value = true
            val result = repository.getAll(query.value, loadingPage)
            val current = ArrayList(recipes.value)
            current.addAll(result)
            recipes.value = current
            loading.value = false
            currentPage = loadingPage
        }
    }

    fun onQueryChanged(query: String) {
        this.query.value = query
        savedState.set(STATE_KEY_QUERY, query)
    }

    fun onChipsScrollPositionChanged(position: Float) {
        this.chipsScrollPosition = position
    }
}