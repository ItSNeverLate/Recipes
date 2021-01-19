package com.example.composemvvmrecipeapp.presentation.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val DefaultLightColors = lightColors(
    primary = Color(0xFF4CAF50),
    primaryVariant = Color(0xFF009688),
    secondary = Color(0xFFFFC107),
    secondaryVariant = Color(0xFF018786),
    background = Color.White,
    surface = Color.White,
    error = Color(0xFFB00020),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

val DefaultDarkColors = darkColors(
    primary = Color(0xFF4CAF50),
    primaryVariant = Color(0xFF009688),
    secondary = Color(0xFFFFC107),
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    error = Color(0xFFCF6679),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.Black
)