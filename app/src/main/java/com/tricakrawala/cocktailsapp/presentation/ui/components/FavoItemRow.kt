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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import com.tricakrawala.cocktailsapp.data.resource.local.entity.CocktailDrink
import com.tricakrawala.cocktailsapp.presentation.ui.theme.CocktailsAppTheme
import com.tricakrawala.cocktailsapp.presentation.ui.theme.White
import com.tricakrawala.cocktailsapp.presentation.ui.theme.fontColor1
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.primary
import com.tricakrawala.cocktailsapp.presentation.ui.theme.red
import com.tricakrawala.cocktailsapp.presentation.viewmodel.favorite.FavoriteViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun FavoItemRow(
    modifier: Modifier = Modifier,
    cocktailDrink: CocktailDrink? = null,
    viewModel: FavoriteViewModel = hiltViewModel(),
    snackbarHostState: SnackbarHostState,
    coroutineScope: CoroutineScope,
    navigateToDetail: (String) -> Unit
) {
    if (cocktailDrink != null) {

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
                            .data(cocktailDrink.image)
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
                        text = stringResource(id = R.string.type, cocktailDrink.type),
                        fontFamily = poppinFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = fontColor1,
                        fontSize = 12.sp
                    )

                    Text(
                        text = stringResource(id = R.string.glass, cocktailDrink.glass),
                        fontFamily = poppinFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = fontColor1,
                        fontSize = 12.sp
                    )

                    Text(
                        text = cocktailDrink.name,
                        fontFamily = poppinFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = fontColor1,
                        fontSize = 14.sp
                    )
                }
            }

            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "favorite",
                tint = red,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 16.dp, bottom = 16.dp)
                    .clickable {
                        viewModel.deleteFavoriteCocktail(cocktailDrink.idDrink)
                        coroutineScope.launch {
                            val job = coroutineScope.launch {
                                val snackbarResult = snackbarHostState.showSnackbar(
                                    message = "Successfully removed from favorites",
                                    actionLabel = "Undo",
                                    duration = SnackbarDuration.Indefinite
                                )

                                if (snackbarResult == SnackbarResult.ActionPerformed) {
                                    viewModel.insertFavoriteCocktail(cocktailDrink)
                                }
                            }
                            delay(2000)
                            job.cancel()
                        }

                    }
            )


            Card(
                colors = CardDefaults.cardColors(red),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp)
                    .clickable { navigateToDetail(cocktailDrink.idDrink) }
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
}


@Composable
@Preview(
    showBackground = true,
    backgroundColor = 2
)
private fun Preview() {
    CocktailsAppTheme {
        FavoItemRow(
            navigateToDetail = {},
            snackbarHostState = SnackbarHostState(),
            coroutineScope = rememberCoroutineScope()
        )
    }
}