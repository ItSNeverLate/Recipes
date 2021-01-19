package com.example.composemvvmrecipeapp.domain.mapper

interface Mapper<Model, T> {

    fun toModel(t: T): Model

    fun fromModel(model: Model): T

    fun fromModelList(list: List<Model>) = list.map { fromModel(it) }

    fun toModelList(list: List<T>) = list.map { toModel(it) }
}