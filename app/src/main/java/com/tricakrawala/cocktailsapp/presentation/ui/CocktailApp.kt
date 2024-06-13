package com.tricakrawala.cocktailsapp.presentation.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tricakrawala.cocktailsapp.presentation.navigation.Screen
import com.tricakrawala.cocktailsapp.presentation.ui.components.BottomBar
import com.tricakrawala.cocktailsapp.presentation.ui.screen.about.AboutScreen
import com.tricakrawala.cocktailsapp.presentation.ui.screen.detaildrink.DetailDrinkScreen
import com.tricakrawala.cocktailsapp.presentation.ui.screen.home.HomeScreen
import com.tricakrawala.cocktailsapp.presentation.ui.screen.reserveation.ReservationScreen
import com.tricakrawala.cocktailsapp.utils.Utils

@RequiresApi(Build.VERSION_CODES.O)
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
                HomeScreen(navToDetail = {idDrink ->
                    navController.navigate(Screen.DetailDrink.createRoute(idDrink))
                })
            }
            composable(Screen.Reservation.route) {
                ReservationScreen(navController = navController)
            }
            composable(Screen.About.route) {
                AboutScreen()
            }
            composable(Screen.DetailDrink.route,
                arguments = listOf(navArgument("idDrink") { type = NavType.StringType }),){
                val idDrink = it.arguments?.getString("idDrink") ?: "Cant find id drink"
                DetailDrinkScreen(id = idDrink, navController = navController)
            }


        }
    }

}