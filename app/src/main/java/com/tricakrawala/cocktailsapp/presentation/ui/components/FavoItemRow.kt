package com.tricakrawala.cocktailsapp.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.presentation.common.Result
import com.tricakrawala.cocktailsapp.presentation.ui.theme.CocktailsAppTheme
import com.tricakrawala.cocktailsapp.presentation.ui.theme.White
import com.tricakrawala.cocktailsapp.presentation.ui.theme.fontColor1
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.primary
import com.tricakrawala.cocktailsapp.presentation.ui.theme.red
import com.tricakrawala.cocktailsapp.presentation.viewmodel.favorite.FavoriteViewModel


@Composable
fun FavoItemRow(
    modifier: Modifier = Modifier,
    idDrink : String,
    image: String,
    type: String,
    glass: String,
    name: String,
    isFavoriteInitial: Boolean,
    viewModel: FavoriteViewModel = hiltViewModel(),
    navigateToDetail: (String) -> Unit
) {
    var isFavorite by remember { mutableStateOf(isFavoriteInitial) }
    val iconFavorite = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(White)
            .height(135.dp)
            .fillMaxWidth()
            .border(width = 2.dp, color = primary, shape = RoundedCornerShape(16.dp))
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .align(Alignment.BottomCenter)
                .padding(horizontal = 2.dp),
            colors = CardDefaults.cardColors(primary)
        ) {}


        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxHeight()
                    .width(115.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.type, type),
                    fontFamily = poppinFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = fontColor1,
                    fontSize = 12.sp
                )

                Text(
                    text = stringResource(id = R.string.glass, glass),
                    fontFamily = poppinFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = fontColor1,
                    fontSize = 12.sp
                )

                Text(
                    text = name,
                    fontFamily = poppinFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = fontColor1,
                    fontSize = 14.sp
                )
            }
        }
        IconButton(
            onClick = {
                isFavorite = !isFavorite
                viewModel.deleteFavoriteCocktail(idDrink)
            },
            modifier = modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp)
        ) {
            Icon(
                imageVector = iconFavorite,
                contentDescription = "favorite",
                tint = red,
                modifier = modifier.padding(bottom = 16.dp)
            )
        }
        val deleteState by viewModel.deleteState.collectAsState()

        when(deleteState){
            is Result.Error -> {}
            Result.Loading -> {}
            is Result.Success -> {
                viewModel.getAllFavorite()
            }
        }

        // "See Detail" button
        Card(
            colors = CardDefaults.cardColors(red),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
                .clickable { navigateToDetail(idDrink) }
        ) {
            Text(
                text = "See Detail",
                fontFamily = poppinFamily,
                fontWeight = FontWeight.SemiBold,
                color = White,
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )
        }
    }
}


@Composable
@Preview(
    showBackground = true,
    backgroundColor = 2
)
private fun Preview() {
    CocktailsAppTheme {
        FavoItemRow(
            idDrink = "",
            image = "R.drawable.dummy_item_row",
            type = "Alcohol",
            glass = "collins glass",
            name = "3-Mle Long",
            isFavoriteInitial = true,
            navigateToDetail = {}
        )
    }
}