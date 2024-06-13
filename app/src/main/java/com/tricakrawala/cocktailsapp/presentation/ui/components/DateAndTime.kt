package com.tricakrawala.cocktailsapp.presentation.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateAndTime(modifier: Modifier = Modifier){
    val selectedDate by remember { mutableStateOf(LocalDate.now()) }
    val selectedTime by remember { mutableStateOf(LocalTime.now()) }

Row(
modifier = Modifier.fillMaxWidth(),
horizontalArrangement = Arrangement.SpaceBetween
) {
    Button(
        onClick = { /* Handle date selection */ },
        colors = ButtonDefaults.buttonColors(Color(0xFFFF4D4D)),
        modifier = Modifier.weight(1f)
    ) {
        Icon(Icons.Filled.DateRange, contentDescription = null)
        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text("Date")
            Text(
                selectedDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
                fontFamily = poppinFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }
    }
    Spacer(modifier = Modifier.width(8.dp))
    Button(
        onClick = { /* Handle time selection */ },
        colors = ButtonDefaults.buttonColors(Color(0xFFFF4D4D)),
        modifier = Modifier.weight(1f)
    ) {
        Icon(painter = painterResource(R.drawable.ic_time_white), contentDescription = null)
        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text("Time")
            Text(
                " ${selectedTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))}",
                fontFamily = poppinFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }
    }
}
}


