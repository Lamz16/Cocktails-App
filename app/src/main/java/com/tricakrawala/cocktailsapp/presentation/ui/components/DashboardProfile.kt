package com.tricakrawala.cocktailsapp.presentation.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.primary

@Composable
fun DasboardProfile(team: Team){

    Column (
        Modifier
            .fillMaxWidth()
            .height(215.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(primary)
            .padding(top = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row( modifier = Modifier
            .padding(start = 25.dp, bottom = 15.dp, top = 10.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,) {
            Image(
                painter = painterResource(id = team.image),
                contentDescription = "profile",
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(24.dp))
            )

            Spacer(modifier = Modifier.size(12.dp))
            Column {
                Text(
                    text = team.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = poppinFamily,
                    color = Color.White
                )
                Text(
                    text = team.univ,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = poppinFamily,
                    color = Color.White
                )
                Text(
                    text = team.rule,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = poppinFamily,
                    color = Color.White
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            AboutTeam(team)
            }
    }
    Spacer(modifier = Modifier.height(18.dp))
}








