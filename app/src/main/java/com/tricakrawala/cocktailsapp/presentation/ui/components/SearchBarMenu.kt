package com.tricakrawala.cocktailsapp.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.presentation.ui.theme.White
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.primary
import com.tricakrawala.cocktailsapp.presentation.ui.theme.red

@Composable
fun SearchBarMenu(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(red)

    ) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            singleLine = true,
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_menu),
                    fontFamily = poppinFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    modifier = modifier.padding(start = 16.dp)
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = primary,
                unfocusedContainerColor = primary,
                unfocusedBorderColor = primary,
                focusedBorderColor = primary,
                unfocusedTextColor = White,
                focusedTextColor = White,
                focusedPlaceholderColor = White,
                unfocusedPlaceholderColor = White
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = modifier
                .height(50.dp)
                .width(280.dp)
        )
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "",
                tint = White
            )
        }
    }
}


@Composable
@Preview(showBackground = false)
private fun Preview() {
    SearchBarMenu(query = "Search Your Drink", onQueryChange = {})
}