package com.tricakrawala.cocktailsapp.presentation.ui.screen.reserveation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.twotone.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.presentation.ui.components.ButtonReserv
import com.tricakrawala.cocktailsapp.presentation.ui.theme.CocktailsAppTheme
import com.tricakrawala.cocktailsapp.presentation.ui.theme.fontColor1
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.primary
@Composable
fun ReservationConfirmationScreen() {
    var name by remember { mutableStateOf("Joe Smith") }
    var phone by remember { mutableStateOf("+62 812345678901") }
    var date by remember { mutableStateOf("Sat, Mar 4") }
    var time by remember { mutableStateOf("14.00") }
    var people by remember { mutableStateOf("12") }
    var table by remember { mutableStateOf("1") }
    val note by remember { mutableStateOf("Sweet 17th Birthday Party")}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primary)
            .padding(13.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_received),
            contentDescription = "Confirmation Icon",
            modifier = Modifier.size(150.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Table Booked Successfully",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Card(
            modifier = Modifier
                .padding(17.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = name,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = fontColor1
                )
                Text(
                    text = phone,
                    fontSize = 18.sp,
                    color = fontColor1
                )
                Spacer(modifier = Modifier.height(16.dp))
                Spacer(modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color.Black))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = "Date Icon",
                                modifier = Modifier.size(28.dp),
                                tint = primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = date,
                                fontSize = 18.sp,
                                color = primary
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_time),
                                contentDescription = "time",
                                modifier = Modifier.size(28.dp),
                                tint = primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = time,
                                fontSize = 18.sp,
                                color = primary)
                        }
                    }
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Face,
                                contentDescription = "People Icon",
                                modifier = Modifier.size(28.dp),
                                tint = primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = people + " People",
                                fontSize = 18.sp,
                                color = primary
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_meja),
                                contentDescription = "Table",
                                modifier = Modifier.size(28.dp),
                                tint = primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Table "+ table,
                                fontSize = 18.sp,
                                color = primary
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color.Black))
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = note,
                    fontSize = 18.sp,
                    color = primary
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ButtonReserv(onClick = {/*Handle Button Here */}, text = "Edit Data", icon = Icons.Default.Edit,)
                    Button(
                        onClick = { /* Handle Cancel     */ },
                        colors = ButtonDefaults.buttonColors(  Color(0xFFDC2626)),
                    ) {
                        Icon(
                            imageVector = Icons.TwoTone.Clear,
                            contentDescription = "clear",
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .size(24.dp),
                            tint = Color.White
                        )
                        Text(
                            text = "Cancel",
                            color = Color.White,
                            modifier = Modifier
                                .padding(end = 4.dp)
                        )
                    }
                }
                ButtonReserv(onClick = {/*Handle Button Here */}, text = "Add To Calendar", icon = Icons.Default.DateRange,modifier = Modifier.fillMaxWidth() .padding(top = 8.dp))
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "We will send more\ninformation via\nWhatsApp",
                    fontFamily = poppinFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = fontColor1,
                    textAlign = TextAlign.Left
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun PreviewThree() {
    CocktailsAppTheme {
        ReservationConfirmationScreen()
    }
}
