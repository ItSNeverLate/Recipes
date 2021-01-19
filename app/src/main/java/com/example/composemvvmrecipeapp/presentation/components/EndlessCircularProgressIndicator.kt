package com.example.composemvvmrecipeapp.presentation.components

import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun EndlessCircularProgressIndicator(
    isVisible: Boolean
) {
    if (isVisible) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (progressBar, text) = createRefs()
            CircularProgressIndicator(modifier = Modifier.constrainAs(progressBar) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
            Text(
                modifier = Modifier
                    .constrainAs(text) {
                        top.linkTo(progressBar.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(8.dp),
                style = TextStyle(color = MaterialTheme.colors.primary),
                text = "Loading..."
            )
        }
    }
}