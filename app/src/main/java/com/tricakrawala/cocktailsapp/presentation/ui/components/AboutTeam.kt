package com.tricakrawala.cocktailsapp.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.domain.model.Team


@Composable
fun AboutTeam(team: Team){
    Column(
        Modifier
            .width(72.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(vertical = 11.dp)
            .clickable {team.email},
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_email),
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)

        )

        Text(
            text = "Email",
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
    }
    Column(
        Modifier
            .width(72.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(vertical = 11.dp)
            .clickable {team.email},
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_phone),
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
        )

        Text(
            text = "Phone",
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
    }
    Column(
        Modifier
            .width(72.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(vertical = 11.dp)
            .clickable {team.email},
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_instagram),
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
        )

        Text(
            text = "Instagram",
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
    }
    Column(
        Modifier
            .width(72.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(vertical = 11.dp)
            .clickable {team.email},
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_linked),
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
        )

        Text(
            text = "LinkedIn",
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
    }
}