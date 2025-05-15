package com.jaennova.dishcovery.api

import com.jaennova.dishcovery.model.RecipeResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MealService {
    @GET("api/json/v1/1/search.php")
    suspend fun searchMeals(@Query("s") query: String): RecipeResponse

    @GET("api/json/v1/1/lookup.php")
    suspend fun getMealById(@Query("i") id: String): RecipeResponse
}

object RetrofitClient {
    private const val BASE_URL = "https://www.themealdb.com/"

    val mealService: MealService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealService::class.java)
    }
}