package com.jaennova.dishcovery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jaennova.dishcovery.ui.screens.RecipeScreen
import com.jaennova.dishcovery.ui.theme.DishcoveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DishcoveryTheme {
                RecipeScreen()
            }
        }
    }
}