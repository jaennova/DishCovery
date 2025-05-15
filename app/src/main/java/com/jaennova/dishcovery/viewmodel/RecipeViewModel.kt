package com.jaennova.dishcovery.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaennova.dishcovery.api.RetrofitClient
import com.jaennova.dishcovery.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> = _recipes.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

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

                val response = RetrofitClient.mealService.searchMeals(query)
                _recipes.value = response.meals ?: emptyList()

            } catch (e: Exception) {
                _error.value = "Error: ${e.localizedMessage}"
                _recipes.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }
}