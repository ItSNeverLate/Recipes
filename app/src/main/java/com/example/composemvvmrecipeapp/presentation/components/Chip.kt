package com.example.composemvvmrecipeapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
fun Chip(
    title: String,
    onClick: () -> Unit,
    isSelected: Boolean = false
) {
    Surface(
        modifier = Modifier
            .padding(start = 4.dp, bottom = 4.dp)
            .clickable(onClick = onClick),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        color = if (isSelected) MaterialTheme.colors.secondary else MaterialTheme.colors.primary
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.body2,
            text = title,
        )
    }
}


@Preview("Chip: example")
@Composable()
fun ChipPreview() {
}