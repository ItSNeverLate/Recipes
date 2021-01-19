package com.example.composemvvmrecipeapp.presentation.ui.recipelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Message
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.WithConstraints
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.composemvvmrecipeapp.App
import com.example.composemvvmrecipeapp.R
import com.example.composemvvmrecipeapp.presentation.components.*
import com.example.composemvvmrecipeapp.presentation.theme.AppTheme
import com.example.composemvvmrecipeapp.presentation.ui.STATE_KEY_RECIPE_ID
import com.example.composemvvmrecipeapp.util.toggle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    @ExperimentalMaterialApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme(isDark = (activity?.application as App).isDark.value) {
                    WithConstraints(modifier = Modifier.fillMaxSize()) {
                        val snackbarHostState = remember { SnackbarHostState() }

                        val isPortrait = maxHeight.value > maxWidth.value

                        // Don' forget to use it in setContent for doing ReCompose
                        val recipes = viewModel.recipes.value

                        val scaffoldState = rememberScaffoldState()

                        Scaffold(
                            scaffoldState = scaffoldState,
                            topBar = {
                                SearchAppBar(
                                    query = viewModel.query.value,
                                    onQueryChanged = { viewModel.onQueryChanged(it) },
                                    onSearchClicked = viewModel::onSearchClicked,
                                    chipsScrollPosition = viewModel.chipsScrollPosition,
                                    onChipsScrollPositionChanged = {
                                        viewModel.onChipsScrollPositionChanged(
                                            it
                                        )
                                    },
                                    onMoreClick = (activity?.application as App)::onToggleDarkMode,
                                    onMenuClick = { scaffoldState.drawerState.toggle() }
                                )
                            },
                            bodyContent = {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(MaterialTheme.colors.background)
                                ) {
                                    LazyColumn {
                                        itemsIndexed(items = recipes) { index, recipe ->
                                            if (index + 1 >= viewModel.loadingPage * PAGE_SIZE)
                                                viewModel.onEndOfListHandle()
                                            RecipeCard(
                                                recipe = recipe,
                                                onClick = {
                                                    val bundle = Bundle()
                                                    bundle.putInt(STATE_KEY_RECIPE_ID, recipe.id)
                                                    findNavController().navigate(
                                                        R.id.viewRecipe,
                                                        bundle
                                                    )
                                                })
                                        }
                                    }
                                    EndlessCircularProgressIndicator(isVisible = viewModel.loading.value)
                                    FloatingActionButton(
                                        modifier = Modifier
                                            .align(Alignment.BottomEnd)
                                            .padding(bottom = 72.dp, end = 16.dp),
                                        onClick = {
                                            Log.d("TAGTAG", "onCreateView: CLICLL")
                                            lifecycleScope.launch {
                                                snackbarHostState?.currentSnackbarData?.dismiss()
                                                snackbarHostState?.showSnackbar(
                                                    message = "Recipe deleted!",
                                                    actionLabel = "Undo",
                                                    duration = SnackbarDuration.Short
                                                )
                                            }
                                        }) {
                                        Icon(Icons.Default.Message)
                                    }
                                    AppSnasckBar(
                                        modifier = Modifier
                                            .align(Alignment.BottomCenter)
                                            .padding(bottom = 112.dp),
                                        snackbarHostState = snackbarHostState,
                                        onActionClicked = { snackbarHostState.currentSnackbarData?.dismiss() }
                                    )
                                }
                            },
                            drawerContent = {
                                AppDrawer()
                            },
                            bottomBar = {
                                AppBottomBar()
                            }
                        )
                    }
                }
            }
        }
    }
}