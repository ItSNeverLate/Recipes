package com.example.composemvvmrecipeapp.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(
    isDark: Boolean,
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colors = if (isDark) DefaultDarkColors else DefaultLightColors,
        typography = DefaultTypography,
        shapes = DefaultShape
    ) { content() }
}