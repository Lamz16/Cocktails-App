package com.tricakrawala.cocktailsapp.presentation.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.presentation.navigation.NavigationItem
import com.tricakrawala.cocktailsapp.presentation.navigation.Screen
import com.tricakrawala.cocktailsapp.presentation.ui.theme.primary

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.menu_home),
                icon = painterResource(id = R.drawable.ic_home),
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_reservation),
                icon = painterResource(id = R.drawable.ic_reserv),
                screen = Screen.Reservation
            ),
            NavigationItem(
                title = stringResource(R.string.menu_about),
                icon = painterResource(id = R.drawable.ic_about),
                screen = Screen.About
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
//                selected = false,
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = primary
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview(modifier: Modifier = Modifier,
                    navController: NavHostController = rememberNavController()
){
    BottomBar(navController =navController)
}