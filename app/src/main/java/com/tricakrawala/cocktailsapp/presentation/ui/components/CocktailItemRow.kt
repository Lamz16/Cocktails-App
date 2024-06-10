package com.tricakrawala.cocktailsapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.presentation.ui.theme.CocktailsAppTheme
import com.tricakrawala.cocktailsapp.presentation.ui.theme.fontColor1
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily

@Composable
fun CocktailItemRow(
    modifier: Modifier = Modifier,
    image: Int,
    nameMenu: String
) {
    Box(
        modifier
            .clip(RoundedCornerShape(16.dp))
            .size(height = 175.dp, width = 150.dp)
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_cock_row),
            contentDescription = "",
            modifier = modifier
                .align(Alignment.Center)
                .fillMaxSize()
                .padding(16.dp)
        )

        Column(
            modifier = modifier
                .align(Alignment.Center)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = image), contentDescription = "", modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .size(height = 105.dp, width = 82.dp)
            )
            Text(
                text = nameMenu,
                fontFamily = poppinFamily,
                fontWeight = FontWeight.Medium,
                modifier = modifier.align(Alignment.CenterHorizontally),
                color = fontColor1,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
@Preview
private fun Preview() {
    CocktailsAppTheme {
        CocktailItemRow(
            image = R.drawable.dummy_item_row,
            nameMenu = "Cocktail"
        )
    }
}

