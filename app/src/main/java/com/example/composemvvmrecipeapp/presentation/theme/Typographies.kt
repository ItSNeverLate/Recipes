package com.example.composemvvmrecipeapp.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.font
import androidx.compose.ui.text.font.fontFamily
import com.example.composemvvmrecipeapp.R

val DancingScript = fontFamily(
    font(R.font.dancing_script_regular, FontWeight.Normal),
    font(R.font.dancing_script_medium, FontWeight.Medium),
    font(R.font.dancing_script_semi_old, FontWeight.SemiBold),
    font(R.font.dancing_script_bold, FontWeight.Bold),
)

val DefaultTypography = Typography(
    defaultFontFamily = DancingScript,
    //h1 = TextStyle()
)