package com.tricakrawala.cocktailsapp.presentation.ui


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.navigationBarsPadding
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tricakrawala.cocktailsapp.presentation.common.Result
import com.tricakrawala.cocktailsapp.presentation.navigation.Screen
import com.tricakrawala.cocktailsapp.presentation.ui.components.BottomBar
import com.tricakrawala.cocktailsapp.presentation.ui.screen.about.AboutScreen
import com.tricakrawala.cocktailsapp.presentation.ui.screen.auth.LoginScreen
import com.tricakrawala.cocktailsapp.presentation.ui.screen.auth.RegisterScreen
import com.tricakrawala.cocktailsapp.presentation.ui.screen.detaildrink.DetailDrinkScreen
import com.tricakrawala.cocktailsapp.presentation.ui.screen.favorite.FavoriteScreen
import com.tricakrawala.cocktailsapp.presentation.ui.screen.home.HomeScreen
import com.tricakrawala.cocktailsapp.presentation.viewmodel.auth.AuthViewModel
import com.tricakrawala.cocktailsapp.utils.Utils

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CocktailApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: AuthViewModel = hiltViewModel()
) {
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route
    val context = LocalContext.current

    val shouldShowBottomBar = currentRoute !in Utils.screenWithoutBottomBar
    val auth by viewModel.session.collectAsState()
    when(val currentAuth = auth){
        is Result.Success -> {
            val startDestination = if (currentAuth.data.isLogin) Screen.Home.route else Screen.Home.route
            Scaffold(
                bottomBar = {
                    if (shouldShowBottomBar) {
                        BottomBar(navController)
                    }
                },
                modifier = modifier
            ) { innerPadding ->

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
                NavHost(
                    navController = navController,
                    startDestination = startDestination,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable(Screen.Home.route) {
                        HomeScreen(navToDetail = {idDrink ->
                            navController.navigate(Screen.DetailDrink.createRoute(idDrink))
                        })
                    }
                    composable(Screen.Favorite.route) {
                        FavoriteScreen(navToDetail = {idDrink ->
                            navController.navigate(Screen.DetailDrink.createRoute(idDrink))
                        })
                    }
                    composable(Screen.About.route) {
                        AboutScreen()
                    }
                    composable(Screen.DetailDrink.route,
                        arguments = listOf(navArgument("idDrink") { type = NavType.StringType }),){
                        val idDrink = it.arguments?.getString("idDrink") ?: "Cant find id drink"
                        DetailDrinkScreen(id = idDrink, navController = navController)
                    }

                    composable(Screen.Login.route){
                        LoginScreen()
                    }
                    composable(Screen.Register.route){
                        RegisterScreen()
                    }


                }
            }
        }

        else -> {
            Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show()
        }
    }

}
