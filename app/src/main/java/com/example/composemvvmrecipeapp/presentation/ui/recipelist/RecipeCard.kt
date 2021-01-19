package com.example.composemvvmrecipeapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.composemvvmrecipeapp.domain.model.Recipe
import com.example.composemvvmrecipeapp.util.loadImage

@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .padding(top = 8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.small,
        elevation = 8.dp,
    ) {
        Column {
            recipe.featuredImage?.let { url ->
                val image = loadImage(url).value
                image?.let {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .preferredHeight(255.dp),
                        contentScale = ContentScale.Crop,
                        bitmap = it.asImageBitmap()
                    )
                }
            }
            recipe.title?.let { title ->
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h6,
                        text = title,
                        maxLines = 1
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically),
                        text = "${recipe.rating.toString()}",
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.primary,
                    )
                }
            }
        }
    }
}