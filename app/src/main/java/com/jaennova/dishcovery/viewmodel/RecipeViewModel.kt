package com.jaennova.dishcovery.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.jaennova.dishcovery.database.RecipeDatabase
import com.jaennova.dishcovery.model.Recipe
import com.jaennova.dishcovery.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: RecipeRepository

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> = _recipes.asStateFlow()

    private val _favorites = MutableStateFlow<List<Recipe>>(emptyList())
    val favorites: StateFlow<List<Recipe>> = _favorites.asStateFlow()

    private val _selectedRecipe = MutableStateFlow<Recipe?>(null)
    val selectedRecipe: StateFlow<Recipe?> = _selectedRecipe.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite.asStateFlow()

    init {
        val dao = RecipeDatabase.getDatabase(application).recipeDao()
        repository = RecipeRepository(dao)

        viewModelScope.launch {
            repository.getAllFavorites().collectLatest {
                _favorites.value = it
            }
        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun searchRecipes() {
        val query = _searchQuery.value
        if (query.isBlank()) return

        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null

                _recipes.value = repository.searchRecipes(query)

            } catch (e: Exception) {
                _error.value = "Error: ${e.localizedMessage}"
                _recipes.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getRecipeDetails(recipeId: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null

                val recipe = repository.getRecipeDetails(recipeId)
                _selectedRecipe.value = recipe

                // Check if it's a favorite
                recipe?.let {
                    _isFavorite.value = repository.isFavorite(it.idMeal)
                }

            } catch (e: Exception) {
                _error.value = "Error: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun toggleFavorite() {
        val recipe = _selectedRecipe.value ?: return

        viewModelScope.launch {
            repository.toggleFavorite(recipe)
            _isFavorite.value = !_isFavorite.value
        }
    }

    fun clearSelectedRecipe() {
        _selectedRecipe.value = null
    }
}