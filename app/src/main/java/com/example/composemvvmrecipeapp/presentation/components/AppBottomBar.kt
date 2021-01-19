package com.example.composemvvmrecipeapp.presentation.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AppBottomBar(
    navController: NavController? = null
) {

    BottomNavigation {
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Search) },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.AccountBalanceWallet) },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.BrokenImage) },
            selected = false,
            onClick = {}
        )
    }
}