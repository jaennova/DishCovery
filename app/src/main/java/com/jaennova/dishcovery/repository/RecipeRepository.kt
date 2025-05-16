package com.jaennova.dishcovery.repository

import com.jaennova.dishcovery.api.RetrofitClient
import com.jaennova.dishcovery.database.RecipeDao
import com.jaennova.dishcovery.model.Recipe
import com.jaennova.dishcovery.model.toFavoriteRecipe
import com.jaennova.dishcovery.model.toRecipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RecipeRepository(private val recipeDao: RecipeDao) {

    // API calls
    suspend fun searchRecipes(query: String): List<Recipe> {
        val response = RetrofitClient.mealService.searchMeals(query)
        return response.meals ?: emptyList()
    }

    suspend fun getRecipeDetails(id: String): Recipe? {
        val response = RetrofitClient.mealService.getMealById(id)
        return response.meals?.firstOrNull()
    }

    // Database operations
    fun getAllFavorites(): Flow<List<Recipe>> {
        return recipeDao.getAllFavorites().map { favorites ->
            favorites.map { it.toRecipe() }
        }
    }

    suspend fun isFavorite(recipeId: String): Boolean {
        return recipeDao.getFavoriteById(recipeId) != null
    }

    suspend fun addToFavorites(recipe: Recipe) {
        recipeDao.insertFavorite(recipe.toFavoriteRecipe())
    }

    suspend fun removeFromFavorites(recipeId: String) {
        recipeDao.removeFavoriteById(recipeId)
    }

    suspend fun toggleFavorite(recipe: Recipe) {
        val isFavorite = isFavorite(recipe.idMeal)
        if (isFavorite) {
            removeFromFavorites(recipe.idMeal)
        } else {
            addToFavorites(recipe)
        }
    }
}