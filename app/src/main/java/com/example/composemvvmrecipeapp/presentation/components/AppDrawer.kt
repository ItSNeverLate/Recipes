package com.example.composemvvmrecipeapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

val ItemModifier = Modifier.padding(20.dp)
    .padding(horizontal = 20.dp)

@Composable
fun AppDrawer(
    navController: NavController? = null
) {
    Column {
        Text(modifier = ItemModifier, text = "ITEM 1")
        Text(modifier = ItemModifier, text = "ITEM 2")
        Text(modifier = ItemModifier, text = "ITEM 3")
        Text(modifier = ItemModifier, text = "ITEM 4")
        Text(modifier = ItemModifier, text = "ITEM 5")
    }
}