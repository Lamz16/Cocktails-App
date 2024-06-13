package com.tricakrawala.cocktailsapp.presentation.Onboarding


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.presentation.ui.theme.CocktailsAppTheme
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.primary

@Composable
fun SecondOnboarding() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(primary),
        contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.luxecocktail), contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 70.dp, bottom = 40.dp)
        ) {
            Text(
                text = "Welcome",
                fontSize = 60.sp,
                letterSpacing = 8.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic
            )
            Text(
                text = "Luxe Cocktails",
                fontSize = 48.sp,
                letterSpacing = 5.sp,
                lineHeight = 70.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = poppinFamily,
                fontStyle = FontStyle.Italic
            )
            Row(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        Color.White,
                        contentColor = Color(0xFFFFF0F5)
                    )
                ) {
                    Text("Sign In",
                        color = Color(0xFF000000))
                }
                Spacer(modifier = Modifier.size(20.dp))
                Button(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        Color.White,
                        contentColor = Color(0xFFFFF0F5)
                    )
                ) {
                    Text("Sign Up",
                        color = Color(0xFF000000))
                }
            }
        }
    }
}
@Composable
@Preview(showBackground = true)
private fun PreviewThree() {
    CocktailsAppTheme {
        SecondOnboarding()
    }
}