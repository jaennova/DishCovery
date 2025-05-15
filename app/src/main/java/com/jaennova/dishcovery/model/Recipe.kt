package com.jaennova.dishcovery.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Recipe(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    val strCategory: String? = null,
    val strArea: String? = null,
    val strInstructions: String? = null,
    val strTags: String? = null,
    val strYoutube: String? = null
)

data class RecipeResponse(
    val meals: List<Recipe>?
)

@Entity(tableName = "favorite_recipes")
data class FavoriteRecipe(
    @PrimaryKey
    val id: String,
    val name: String,
    val thumbnailUrl: String,
    val category: String?,
    val area: String?,
    val instructions: String?,
    val tags: String?,
    val youtubeUrl: String?,
    val isFavorite: Boolean = true
)

fun Recipe.toFavoriteRecipe(): FavoriteRecipe {
    return FavoriteRecipe(
        id = idMeal,
        name = strMeal,
        thumbnailUrl = strMealThumb,
        category = strCategory,
        area = strArea,
        instructions = strInstructions,
        tags = strTags,
        youtubeUrl = strYoutube
    )
}

fun FavoriteRecipe.toRecipe(): Recipe {
    return Recipe(
        idMeal = id,
        strMeal = name,
        strMealThumb = thumbnailUrl,
        strCategory = category,
        strArea = area,
        strInstructions = instructions,
        strTags = tags,
        strYoutube = youtubeUrl
    )
}