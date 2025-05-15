package com.jaennova.dishcovery.database

import androidx.room.*
import com.jaennova.dishcovery.model.FavoriteRecipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("SELECT * FROM favorite_recipes")
    fun getAllFavorites(): Flow<List<FavoriteRecipe>>

    @Query("SELECT * FROM favorite_recipes WHERE id = :recipeId")
    suspend fun getFavoriteById(recipeId: String): FavoriteRecipe?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(recipe: FavoriteRecipe)

    @Delete
    suspend fun removeFavorite(recipe: FavoriteRecipe)

    @Query("DELETE FROM favorite_recipes WHERE id = :recipeId")
    suspend fun removeFavoriteById(recipeId: String)
}