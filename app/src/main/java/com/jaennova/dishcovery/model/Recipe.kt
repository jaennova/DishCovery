package com.jaennova.dishcovery.model

data class Recipe(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    val strCategory: String? = null,
    val strInstructions: String? = null
)

data class RecipeResponse(
    val meals: List<Recipe>?
)