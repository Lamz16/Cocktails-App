package com.tricakrawala.cocktailsapp.presentation.ui.screen.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.data.resource.local.entity.CocktailDrink
import com.tricakrawala.cocktailsapp.presentation.common.Result
import com.tricakrawala.cocktailsapp.presentation.ui.components.FavoItemRow
import com.tricakrawala.cocktailsapp.presentation.ui.components.SearchBarMenu
import com.tricakrawala.cocktailsapp.presentation.ui.theme.fontColor1
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.red
import com.tricakrawala.cocktailsapp.presentation.viewmodel.favorite.FavoriteViewModel

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel(),
    navToDetail: (String) -> Unit,
) {
    val listCocktail by viewModel.listFavorite.collectAsState(initial = Result.Loading)

    when (val drink = listCocktail) {
        is Result.Error -> {}
        Result.Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        is Result.Success -> {
            FavoriteContent(
                listDrink = drink.data,
                navToDetail = navToDetail,
                viewModel = viewModel
            )
        }
    }


}

@Composable
fun FavoriteContent(
    listDrink: List<CocktailDrink>,
    navToDetail: (String) -> Unit,
    viewModel: FavoriteViewModel
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    var query by remember { mutableStateOf("") }
    val filteredList = remember(query, listDrink) {
        if (query.isEmpty()) {
            listDrink
        } else {
            listDrink.filter {
                it.name.contains(query, ignoreCase = true) ||
                        it.type.contains(query, ignoreCase = true) ||
                        it.glass.contains(query, ignoreCase = true)
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(innerPadding)
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = R.string.favo_say),
                    fontFamily = poppinFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 30.sp,
                    color = red,
                    letterSpacing = 2.sp,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 50.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.favo_ic), contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(width = 43.dp, height = 80.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            SearchBarMenu(query = query, onQueryChange = { newQuery ->
                query = newQuery
            }, modifier = Modifier.align(Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.height(24.dp))

            val insertState by viewModel.insertState.collectAsState()

            val deleteState by viewModel.deleteState.collectAsState()

                when (insertState) {
                    is Result.Success -> {
                        viewModel.getAllFavorite()
                    }

                    else -> {}
                }

                when (deleteState) {
                    is Result.Success -> {
                        viewModel.getAllFavorite()

                    }

                    else -> {}
                }


            if (filteredList.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(filteredList) {
                        FavoItemRow(
                            cocktailDrink = it,
                            snackbarHostState = snackbarHostState,
                            coroutineScope = coroutineScope,
                            navigateToDetail = navToDetail
                        )
                    }
                }
            } else {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Favorite Empty",
                        fontFamily = poppinFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = fontColor1,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}