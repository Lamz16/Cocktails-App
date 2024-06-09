package com.tricakrawala.cocktailsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.tricakrawala.cocktailsapp.presentation.ui.CocktailApp
import com.tricakrawala.cocktailsapp.presentation.ui.theme.CocktailsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CocktailsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                CocktailApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}