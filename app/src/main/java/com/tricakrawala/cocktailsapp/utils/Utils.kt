package com.tricakrawala.cocktailsapp.utils

import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.domain.model.Drink
import com.tricakrawala.cocktailsapp.presentation.navigation.Screen

object Utils {
    val screenWithoutBottomBar = listOf(
        Screen.DetailDrink.route
    )

    const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

    val listDrink = listOf(
        Drink(1, R.drawable.dummy_item_row, "Cocktail", "Lorem ipsum"),
        Drink(2, R.drawable.dummy_item_row, "Cocktail", "Lorem ipsum"),
        Drink(3, R.drawable.dummy_item_row, "Cocktail", "Lorem ipsum"),
        Drink(4, R.drawable.dummy_item_row, "Cocktail", "Lorem ipsum"),
    )
}