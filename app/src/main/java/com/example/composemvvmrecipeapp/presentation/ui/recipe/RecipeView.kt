package com.example.composemvvmrecipeapp.presentation.ui.recipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.composemvvmrecipeapp.domain.model.Recipe
import com.example.composemvvmrecipeapp.util.loadImage

@Composable
fun RecipeView(
    recipe: Recipe?
) {
    recipe?.let { recipe ->
        Column() {
            recipe.featuredImage?.let { imageUrl ->
                val image = loadImage(url = imageUrl)
                image.value?.let {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .preferredHeight(300.dp),
                        bitmap = it.asImageBitmap(),
                        contentScale = ContentScale.Crop
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h5,
                        text = recipe.title,
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
                ScrollableColumn(modifier = Modifier.padding(8.dp)) {
                    recipe.ingredients?.map { ingredient ->
                        Text(
                            style = MaterialTheme.typography.body1
                                .merge(TextStyle(color = MaterialTheme.colors.secondary)),
                            text = ingredient
                        )
                    }
                }
            }
        }
    }
}
