package com.tricakrawala.cocktailsapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.presentation.ui.theme.White
import com.tricakrawala.cocktailsapp.presentation.ui.theme.fontColor1
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.primary
import com.tricakrawala.cocktailsapp.presentation.ui.theme.primary3
import com.tricakrawala.cocktailsapp.presentation.ui.theme.red

@Composable
fun CocktailItemRow(
    modifier: Modifier = Modifier,
    image: String,
    nameMenu: String
) {
    Box(
        modifier
            .clip(RoundedCornerShape(16.dp))
            .size(height = 175.dp, width = 150.dp)
            .background(
                brush = Brush.radialGradient(
                colors = listOf(
                    red, primary, primary3,White, White
                ),
                    ))
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

            Card(
                modifier = Modifier
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .size(80.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "", modifier = modifier.fillMaxSize()
                )
            }


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

