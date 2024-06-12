package com.tricakrawala.cocktailsapp.presentation.ui.screen.reserveation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.presentation.common.Result
import com.tricakrawala.cocktailsapp.presentation.ui.components.ButtonAddReserv
import com.tricakrawala.cocktailsapp.presentation.ui.components.DateAndTime
import com.tricakrawala.cocktailsapp.presentation.ui.components.FormText
import com.tricakrawala.cocktailsapp.presentation.ui.components.NoteText
import com.tricakrawala.cocktailsapp.presentation.ui.components.TextPeople
import com.tricakrawala.cocktailsapp.presentation.ui.components.TextPhone
import com.tricakrawala.cocktailsapp.presentation.ui.components.ToggleButton
import com.tricakrawala.cocktailsapp.presentation.ui.theme.CocktailsAppTheme
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.red
import com.tricakrawala.cocktailsapp.presentation.viewmodel.reserveation.ReservationViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReservationScreen(
    viewModel: ReservationViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(true) {
        if (uiState is Result.Loading) {
            viewModel.getReservation()
        }
    }

    when (val reservation = uiState) {
        is Result.Error -> {}
        Result.Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        is Result.Success -> {
            ReservationContent(navController)
        }
    }

}


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservationContent(
    navController: NavHostController
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())

    ) {

        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.reservation),
                    fontFamily = poppinFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = red,
                    fontSize = 25.sp
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "kembali",
                        modifier = Modifier.size(28.dp),
                        tint = red
                    )
                }
            },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp),
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(Color.Transparent)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 88.dp, start = 24.dp, end = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        FormText()
        TextPhone()
        DateAndTime()
        TextPeople()
        ToggleButton()
        NoteText()
        ButtonAddReserv(teks = "Add Reservation", modifier = Modifier.padding(horizontal = 24.dp))
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = true)
private fun PreviewThree() {
    CocktailsAppTheme {
        ReservationContent(navController = NavHostController(LocalContext.current))
    }
}