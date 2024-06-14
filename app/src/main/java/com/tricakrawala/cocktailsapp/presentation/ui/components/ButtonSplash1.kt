package com.tricakrawala.cocktailsapp.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily

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
            .width(400.dp)
            .clickable { onClick() }
    ) {

        Text(
            modifier = Modifier.fillMaxWidth().align(Alignment.Center),
            text = text,
            color = textColor,
            textAlign = TextAlign.Center,
            fontFamily = poppinFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
    }
}