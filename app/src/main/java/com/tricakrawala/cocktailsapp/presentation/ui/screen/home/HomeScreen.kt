package com.tricakrawala.cocktailsapp.presentation.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.data.resource.remote.response.DrinksItem
import com.tricakrawala.cocktailsapp.presentation.common.Result
import com.tricakrawala.cocktailsapp.presentation.ui.components.CocktailItemRow
import com.tricakrawala.cocktailsapp.presentation.ui.components.SearchBarMenu
import com.tricakrawala.cocktailsapp.presentation.ui.theme.CocktailsAppTheme
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.red
import com.tricakrawala.cocktailsapp.presentation.viewmodel.home.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navToDetail : (String) -> Unit,

) {
    val uiState by viewModel.uiState.collectAsState()

    when(val data = uiState){
        is Result.Error -> {}
        Result.Loading -> {
            Box(modifier = Modifier.fillMaxSize()){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        is Result.Success ->{
            Box(modifier = Modifier.fillMaxSize()){
                HomeContent(listDrink = data.data, navToDetail = navToDetail)
            }

        }
    }

}


@Composable
fun HomeContent(
    listDrink : List<DrinksItem> = emptyList(),
    navToDetail: (String) -> Unit,
) {
    var query by remember { mutableStateOf("") }
    val filteredList = remember(query, listDrink) {
        if (query.isEmpty()) {
            listDrink
        } else {
            listDrink.filter {
                it.strDrink.contains(query, ignoreCase = true)
            }
        }
    }


    Column(
        Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .statusBarsPadding()
            .padding(horizontal = 16.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.home_say),
                fontFamily = poppinFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp,
                color = red,
                letterSpacing = 2.sp,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 16.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.glass_home), contentDescription = "",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 16.dp)
                    .size(width = 43.dp, height = 80.dp)
            )

        }


        Spacer(modifier = Modifier.height(24.dp))
        SearchBarMenu(query = query, onQueryChange = { newQuery ->
            query = newQuery
        }, modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(24.dp))

        LazyVerticalGrid(
            columns = GridCells.Adaptive(120.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(filteredList){
                CocktailItemRow(image = it.strDrinkThumb, nameMenu = it.strDrink, modifier = Modifier.clickable { navToDetail(it.idDrink) })
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    CocktailsAppTheme {
        HomeContent(
            listDrink = emptyList(),
            navToDetail = {}
        )
    }
}