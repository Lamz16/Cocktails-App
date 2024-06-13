package com.tricakrawala.cocktailsapp.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tricakrawala.cocktailsapp.presentation.ui.theme.White
import com.tricakrawala.cocktailsapp.presentation.ui.theme.fontColor1
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.red

@Composable
fun ButtonAddReserv(
    modifier: Modifier = Modifier,
    isFavorite : Boolean,
){
    val teks = if (isFavorite) "Delete from Favorite" else "Save to Favorite"
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(red)
            .fillMaxWidth()
            .height(50.dp)
    ){
        Text(
            text = teks,
            fontFamily = poppinFamily,
            fontWeight = FontWeight.SemiBold,
            color = White,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}