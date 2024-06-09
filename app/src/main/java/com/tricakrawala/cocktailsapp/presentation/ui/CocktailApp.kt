package com.tricakrawala.cocktailsapp.presentation.ui

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tricakrawala.cocktailsapp.presentation.navigation.Screen
import com.tricakrawala.cocktailsapp.presentation.ui.components.BottomBar
import com.tricakrawala.cocktailsapp.presentation.ui.screen.about.AboutScreen
import com.tricakrawala.cocktailsapp.presentation.ui.screen.home.HomeScreen
import com.tricakrawala.cocktailsapp.presentation.ui.screen.reserveation.ReservationScreen
import com.tricakrawala.cocktailsapp.utils.Utils

@Composable
fun CocktailApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route

    val shouldShowBottomBar = currentRoute !in Utils.screenWithoutBottomBar

    Scaffold(
        bottomBar = {
            if (shouldShowBottomBar) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Reservation.route) {
                ReservationScreen()
            }
            composable(Screen.About.route) {
                AboutScreen()
            }

        }
    }

}