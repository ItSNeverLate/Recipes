package com.example.composemvvmrecipeapp.util

import androidx.compose.material.DrawerState

fun DrawerState.toggle(){
    if (this.isClosed) {
        this.open()
    } else{
        this.close()
    }
}