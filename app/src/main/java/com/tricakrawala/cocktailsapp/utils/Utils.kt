package com.tricakrawala.cocktailsapp.utils

import com.tricakrawala.cocktailsapp.presentation.navigation.Screen

object Utils {
    val screenWithoutBottomBar = listOf(
        Screen.DetailDrink.route,
        Screen.Login.route,
        Screen.Register.route,
        Screen.FirstOnBoard.route,
        Screen.SecondOnBoard.route
    )

    const val BASE_URL = ""


}