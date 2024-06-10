package com.tricakrawala.cocktailsapp.presentation.ui.screen.home

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.tricakrawala.cocktailsapp.domain.model.Drink
import com.tricakrawala.cocktailsapp.presentation.ui.components.CocktailItemRow
import com.tricakrawala.cocktailsapp.presentation.ui.components.SearchBarMenu
import com.tricakrawala.cocktailsapp.presentation.ui.theme.CocktailsAppTheme
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.red
import com.tricakrawala.cocktailsapp.presentation.viewmodel.home.HomeViewModel
import com.tricakrawala.cocktailsapp.utils.Utils

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    Box {
        HomeContent()
    }

}


@Composable
fun HomeContent(
    listDrink : List<Drink> = emptyList()
) {
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

        var query by remember { mutableStateOf("") }
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
            items(listDrink){
                CocktailItemRow(image = it.Image, nameMenu = it.title)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    CocktailsAppTheme {
        HomeContent(
            listDrink = Utils.listDrink
        )
    }
}