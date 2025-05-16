package com.jaennova.dishcovery.api

import com.jaennova.dishcovery.model.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealService {
    @GET("api/json/v1/1/search.php")
    suspend fun searchMeals(@Query("s") query: String): RecipeResponse

    @GET("api/json/v1/1/lookup.php")
    suspend fun getMealById(@Query("i") id: String): RecipeResponse
}