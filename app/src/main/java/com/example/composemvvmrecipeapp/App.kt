package com.example.composemvvmrecipeapp

import android.app.Application
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    // TODO: should be saved in datastore
    val isDark = mutableStateOf(true)

    fun onToggleDarkMode() {
        isDark.value = !isDark.value
    }
}