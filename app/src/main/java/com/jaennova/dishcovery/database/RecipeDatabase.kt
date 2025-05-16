package com.jaennova.dishcovery.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jaennova.dishcovery.model.FavoriteRecipe

@Database(entities = [FavoriteRecipe::class], version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}