package com.tricakrawala.cocktailsapp.presentation.ui.screen.detaildrink

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.data.resource.local.entity.CocktailDrink
import com.tricakrawala.cocktailsapp.data.resource.remote.response.DrinksItem
import com.tricakrawala.cocktailsapp.presentation.common.Result
import com.tricakrawala.cocktailsapp.presentation.navigation.Screen
import com.tricakrawala.cocktailsapp.presentation.ui.components.ButtonAddReserv
import com.tricakrawala.cocktailsapp.presentation.ui.components.ImgDetail
import com.tricakrawala.cocktailsapp.presentation.ui.theme.fontColor1
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.primary
import com.tricakrawala.cocktailsapp.presentation.viewmodel.detaildrink.DetailViewModel

@Composable
fun DetailDrinkScreen(
    id: String,
    viewModel: DetailViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(id) {
        if (uiState is Result.Loading) {
            viewModel.getDetailCocktail(id)
        }
    }

    when (val data = uiState) {
        is Result.Error -> {}
        Result.Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        is Result.Success -> {
            data.data.firstOrNull()?.let { drink ->
                DetailContent(drink, navController, viewModel = viewModel)
            } ?: run {
                Box(Modifier.fillMaxSize()) {
                    Text(
                        text = "Data is null or empty",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailContent(
    drinkData: DrinksItem,
    navController: NavHostController,
    viewModel: DetailViewModel,
) {

    val ingredients = listOf(
        drinkData.strIngredient1,
        drinkData.strIngredient2,
        drinkData.strIngredient3,
        drinkData.strIngredient4,
        drinkData.strIngredient5,
        drinkData.strIngredient6,
        drinkData.strIngredient7,
        drinkData.strIngredient8,
        drinkData.strIngredient9,
        drinkData.strIngredient10,
        drinkData.strIngredient11,
        drinkData.strIngredient12,
        drinkData.strIngredient13,
        drinkData.strIngredient14,
        drinkData.strIngredient15
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        CenterAlignedTopAppBar(
            title = { Text(text = "Drink Detail") },
            navigationIcon = {
                IconButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = stringResource(id = R.string.back),
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(Color.Transparent),
        )

        ImgDetail(image = drinkData.strDrinkThumb ?: "", title = drinkData.strDrink ?: "", modifier = Modifier.align(Alignment.CenterHorizontally))
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Card(shape = RoundedCornerShape(16.dp), modifier = Modifier.padding(horizontal = 24.dp), colors = CardDefaults.cardColors(
            primary)){
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = drinkData.strInstructions ?: "",
                fontFamily = poppinFamily,
                fontWeight = FontWeight.SemiBold,
                color = fontColor1,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(shape = RoundedCornerShape(16.dp), modifier = Modifier.padding(horizontal = 24.dp), colors = CardDefaults.cardColors(
            primary)){
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Text(
                    text = stringResource(id = R.string.type, drinkData.strAlcoholic),
                    fontFamily = poppinFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = fontColor1,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = stringResource(id = R.string.glass, drinkData.strGlass ?: ""),
                    fontFamily = poppinFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = fontColor1,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            Text(
                text = "Ingredients:",
                fontFamily = poppinFamily,
                fontWeight = FontWeight.SemiBold,
                color = fontColor1,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            // list Ingredients
            for (ingredient in ingredients) {
                if (ingredient != null) {
                    Row {
                        Text(
                            text = "•",
                            fontFamily = poppinFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = fontColor1,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )

                        Text(
                            text = "$ingredient",
                            fontFamily = poppinFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = fontColor1,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )

                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
        Spacer(modifier = Modifier.weight(1f))

        val favoriteList by viewModel.listFavorite.collectAsState()
        val isFavorite = favoriteList is Result.Success && (favoriteList as Result.Success<List<CocktailDrink>>).data.any { it.idDrink == drinkData.idDrink }


        ButtonAddReserv(isFavorite = isFavorite, modifier = Modifier.padding(horizontal = 24.dp).clickable {
            val drinkData = CocktailDrink(
                idDrink = drinkData.idDrink,
                name = drinkData.strDrink,
                image = drinkData.strDrinkThumb,
                type = drinkData.strAlcoholic,
                glass = drinkData.strGlass,
                isFavorite = true
            )
            if (isFavorite) {
                viewModel.deleteFavoriteCocktail(drinkData.idDrink)
            } else {
                viewModel.insertFavoriteCocktail(drinkData)
            }
            navController.navigate(Screen.Favorite.route){
                popUpTo(Screen.Home.route)
            }
        })
    }

}

@Preview
@Composable
fun DetailPreview() {
    DetailDrinkScreen(id = "17222", navController = rememberNavController())
}

