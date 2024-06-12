package com.tricakrawala.cocktailsapp.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tricakrawala.cocktailsapp.presentation.ui.screen.reserveation.ReservationConfirmationScreen
import com.tricakrawala.cocktailsapp.presentation.ui.theme.CocktailsAppTheme
import com.tricakrawala.cocktailsapp.presentation.ui.theme.primary
import com.tricakrawala.cocktailsapp.presentation.ui.theme.red

@Composable
fun ButtonReserv(
    onClick: () -> Unit,
    text: String,
    borderColor: Color = red,
    icon: ImageVector,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
             Color.Transparent,
        ),
        border = BorderStroke(width = 2.dp, color = borderColor),
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            modifier = Modifier
                .size(24.dp),
            tint = red
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text,
            color = borderColor,
            modifier = Modifier)
    }

}

@Composable
@Preview(showBackground = true)
private fun PreviewThree() {
    CocktailsAppTheme {
        ButtonReserv(onClick = {}, text = "Edit", icon = Icons.Default.Edit)
    }
}