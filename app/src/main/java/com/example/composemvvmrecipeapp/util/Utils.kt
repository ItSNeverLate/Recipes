package com.example.composemvvmrecipeapp.util

val <T> T.exhaustive: T
    get() = this

val Long.dollar: String
    get() = "$this $"

fun main() {
    val price = 25000L
    print(price.exhaustive)
}