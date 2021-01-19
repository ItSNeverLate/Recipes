package com.example.composemvvmrecipeapp.data.network

import com.example.composemvvmrecipeapp.BuildConfig
import com.example.composemvvmrecipeapp.data.network.dto.RecipeDto
import com.example.composemvvmrecipeapp.data.network.response.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AppService {

    @Headers("Authorization: ${BuildConfig.API_KEY}")
    @GET("search")
    suspend fun getAll(
        @Query("query") query: String,
        @Query("page") page: Int
    ): RecipeResponse

    @Headers("Authorization: ${BuildConfig.API_KEY}")
    @GET("get")
    suspend fun getById(@Query("id") id: Int): RecipeDto
}