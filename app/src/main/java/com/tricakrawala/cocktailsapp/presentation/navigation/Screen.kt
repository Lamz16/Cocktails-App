package com.tricakrawala.cocktailsapp.presentation.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object About : Screen("about")

    data object Reservation : Screen("reservation")
    data object DetailDrink : Screen("home/{idDrink}"){
        fun createRoute(idDrink: String) = "home/$idDrink"
    }

}