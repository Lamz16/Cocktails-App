package com.tricakrawala.cocktailsapp.utils

import com.tricakrawala.cocktailsapp.presentation.navigation.Screen

object Utils {
    val screenWithoutBottomBar = listOf(
        Screen.DetailDrink.route
    )

    const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"
}