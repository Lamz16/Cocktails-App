package com.tricakrawala.cocktailsapp.presentation.ui.screen.about

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.data.DataTeam.members
import com.tricakrawala.cocktailsapp.domain.model.Team
import com.tricakrawala.cocktailsapp.presentation.ui.components.DasboardProfile
import com.tricakrawala.cocktailsapp.presentation.ui.screen.home.HomeContent
import com.tricakrawala.cocktailsapp.presentation.ui.theme.CocktailsAppTheme
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.red

@Composable
fun AboutScreen(){
    AboutContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp) // Add horizontal padding for content spacing
    ) {

        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.about),
                    fontFamily = poppinFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = red,
                    fontSize = 25.sp
                )
            },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp),
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(Color.Transparent)
        )

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter) // Align the Column to the top center of the Box
                .padding(
                    top = 80.dp,
                    bottom = 16.dp
                ) // Adjust top padding as needed for vertical positioning
        ) {
            Text(
                text = "Welcome to CocktailsApp, your ultimate guide to cocktails!",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 16.dp),
                textAlign = TextAlign.Center // Center align the text
            )

            Text(
                text = "Explore a variety of cocktail recipes and mark your favorites for quick access.",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 24.dp),
                textAlign = TextAlign.Center // Center align the text
            )

            // Key Features
            Text(
                text = "Key Features:",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "- Home screen with a curated list of cocktails",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "- Favorite cocktails feature for quick access",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Spacer(modifier = Modifier.height(18.dp))
                Text(
                    text = "Our Team",
                    fontFamily = poppinFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = red,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }


    LazyColumn (
        modifier = Modifier
            .padding(top = 450.dp, start = 20.dp, end= 20.dp)) {
        items(members){teams ->
            DasboardProfile(teams)
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    CocktailsAppTheme {
        AboutContent()
    }
}

