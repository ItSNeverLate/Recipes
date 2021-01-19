package com.example.composemvvmrecipeapp.presentation.components

import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.composemvvmrecipeapp.presentation.ui.recipelist.FoodCategory

@Suppress("unused")
@Composable
fun SearchAppBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onSearchClicked: () -> Unit,
    chipsScrollPosition: Float,
    onChipsScrollPositionChanged: (Float) -> Unit,
    onMoreClick: () -> Unit,
    onMenuClick : () -> Unit
) {
    Surface(
        elevation = 8.dp,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    onClick = { onMenuClick() }) {
                    Icon(Icons.Filled.Menu)
                }
                TextField(
                    value = query,
                    onValueChange = { newQuery ->
                        onQueryChanged(newQuery)
                    },
                    modifier = Modifier
                        .fillMaxWidth(.9f)
                        .padding(8.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.surface),
                    label = {
                        Text(text = "Search")
                    },
                    leadingIcon = {
                        Icon(Icons.Default.Search)
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Search,
                        keyboardType = KeyboardType.Text,
                    ),
                    onImeActionPerformed = { action, keyboardController ->
                        if (action == ImeAction.Search) {
                            onSearchClicked()
                            keyboardController?.hideSoftwareKeyboard()
                        }
                    },
                    textStyle = TextStyle(
                        color = MaterialTheme.colors.onSurface
                    ),
                    backgroundColor = MaterialTheme.colors.surface,
                )
                IconButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    onClick = { onMoreClick() }) {
                    Icon(Icons.Filled.MoreVert)
                }
            }
            val scrollState = rememberScrollState()
            ScrollableRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 4.dp),
                scrollState = scrollState
            ) {
                scrollState.scrollTo(chipsScrollPosition)
                FoodCategory.values().map { foodCategory ->
                    Chip(
                        title = foodCategory.value,
                        onClick = {
                            onQueryChanged(foodCategory.value)
                            onSearchClicked()
                            onChipsScrollPositionChanged(scrollState.value)
                        },
                        isSelected = query == foodCategory.value
                    )
                }
            }
        }
    }
}