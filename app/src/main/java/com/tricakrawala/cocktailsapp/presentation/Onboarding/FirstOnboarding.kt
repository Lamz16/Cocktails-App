package com.tricakrawala.cocktailsapp.presentation.Onboarding


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.presentation.ui.theme.CocktailsAppTheme
import com.tricakrawala.cocktailsapp.presentation.ui.theme.fontColor1
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.primary
import com.tricakrawala.cocktailsapp.presentation.ui.theme.red

@Composable
fun FirstOnboarding(
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {

        Box(
        ) {

            Image(
                painter = painterResource(id = R.drawable.ellipse),
                contentDescription = "ellips",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .width(180.dp)
                    .height(120.dp)

            )
            Text(
                text = stringResource(id = R.string.slogan1),
                modifier = Modifier
                    .padding(top = 60.dp, start = 30.dp, end = 120.dp),
                textAlign = TextAlign.Left,
                lineHeight = 50.sp,
                color = red,
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinFamily
            )
        }

        Image(
            painter = painterResource(id = R.drawable.glass),
            contentDescription = "logo Unesco",
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
        )


        Text(
            text = stringResource(id = R.string.slogan2),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            textAlign = TextAlign.Center,
            color = fontColor1,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .navigationBarsPadding()
        ) {

            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 36.dp)
            ) {
                ButtonSplash1(
                    onClick = { },
                    color = primary,
                    text = stringResource(id = R.string.selanjutnya),
                    textColor = Color.White
                )
            }
        }

    }

}

@Composable
fun ButtonSplash1(
    color: Color,
    text: String,
    textColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color)
            .height(42.dp)
            .width(160.dp)
            .clickable { onClick() }
    ) {

        Text(
            modifier = Modifier.fillMaxWidth().align(Alignment.Center),
            text = text,
            color = textColor,
            textAlign = TextAlign.Center,
            fontFamily = poppinFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
        )
    }
}



@Composable
@Preview(showBackground = true)
private fun PreviewThree() {
    CocktailsAppTheme {
        FirstOnboarding()
    }
}