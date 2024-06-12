package com.tricakrawala.cocktailsapp.presentation.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.primary
import com.tricakrawala.cocktailsapp.presentation.ui.theme.red

@Composable
fun FormText(
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }

    Column(
    ) {
        Text(
            text = "Your Name",
            fontFamily = poppinFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = primary,
            modifier = modifier
                .padding(start = 16.dp)
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primary,
                unfocusedBorderColor = primary, // Warna outline saat tidak focused
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun TextPhone(
    modifier: Modifier = Modifier
) {
    var phoneNumber by remember { mutableStateOf("") }

    Column(
    ) {
        Text(
            text = "Phone Number",
            fontFamily = poppinFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = primary,
            modifier = modifier
                .padding(start = 16.dp)
        )
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primary,
                unfocusedBorderColor = primary, // Warna outline saat tidak focused
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun NoteText(
    modifier: Modifier = Modifier
) {
    var notes by remember { mutableStateOf("Sweet 17th Birthday PartySweet 17th Birthday PartySweet 17th Birthday PartySweet 17th Birthday Party") }


    Column(
    ) {
        Text(
            text = "Notes",
            fontFamily = poppinFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = primary,
            modifier = modifier
                .padding(start = 16.dp)
        )
        OutlinedTextField(
            value = notes,
            onValueChange = { notes = it },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primary,
                unfocusedBorderColor = primary, // Warna outline saat tidak focused
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = modifier
                .fillMaxWidth(),

            )
    }
}

@Composable
fun TextPeople() {
    var peopleCount by remember { mutableStateOf(25) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedTextField(
            value = "$peopleCount People",
            onValueChange = { /* Handle people count change */ },
            readOnly = true,
            label = { Text(text = "People",
                color = primary) },
            leadingIcon ={
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "people",
                    tint = red
                )
            },
            trailingIcon = {
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(end = 15.dp, top = 8.dp, bottom = 8.dp)) {
                    IconButton(
                        onClick = { peopleCount-- },
                        enabled = peopleCount > 1,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(red)
                            .size(40.dp)
                    )
                    {
                        Icon(
                            painter = painterResource(R.drawable.ic_minus),
                            contentDescription = "Decrease",
                            tint = Color.White,
                            modifier = Modifier
                                .size(20.dp),
                        )
                    }
                    Spacer(modifier = Modifier.width(24.dp))
                    IconButton(
                        onClick = { peopleCount++ },
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(red)
                            .size(40.dp)){
                        Icon(
                            Icons.Default.Add,
                            tint = Color.White,
                            contentDescription = "Increase")
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primary,
                unfocusedBorderColor = primary, // Warna outline saat tidak focused
            ),
            modifier = Modifier
                .weight(1f),
        )

    }
}

@Composable
@Preview(showBackground = true)
private fun preview(){
    TextPeople()
}