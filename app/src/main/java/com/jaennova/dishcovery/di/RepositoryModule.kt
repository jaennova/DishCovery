package com.jaennova.dishcovery.di

import com.jaennova.dishcovery.api.MealService
import com.jaennova.dishcovery.database.RecipeDao
import com.jaennova.dishcovery.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRecipeRepository(
        mealService: MealService,
        recipeDao: RecipeDao
    ): RecipeRepository {
        return RecipeRepository(mealService, recipeDao)
    }
}