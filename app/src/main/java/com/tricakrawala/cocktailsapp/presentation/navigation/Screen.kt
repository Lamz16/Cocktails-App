package com.tricakrawala.cocktailsapp.presentation.navigation

sealed class Screen(val route: String) {
    data object FirstOnBoard : Screen("firstonboard")
    data object SecondOnBoard : Screen("secondonboard")
    data object Home : Screen("home")
    data object About : Screen("about")

    data object Favorite : Screen("favorite")
    data object DetailDrink : Screen("home/{idDrink}"){
        fun createRoute(idDrink: String) = "home/$idDrink"
    }

    data object Login : Screen("login")
    data object Register : Screen("register")

}