package com.tricakrawala.cocktailsapp.presentation.ui.screen.auth

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tricakrawala.cocktailsapp.R
import com.tricakrawala.cocktailsapp.data.pref.AuthModel
import com.tricakrawala.cocktailsapp.presentation.common.Result
import com.tricakrawala.cocktailsapp.presentation.navigation.Screen
import com.tricakrawala.cocktailsapp.presentation.ui.theme.CocktailsAppTheme
import com.tricakrawala.cocktailsapp.presentation.ui.theme.poppinFamily
import com.tricakrawala.cocktailsapp.presentation.ui.theme.primary
import com.tricakrawala.cocktailsapp.presentation.ui.theme.red
import com.tricakrawala.cocktailsapp.presentation.viewmodel.auth.AuthViewModel

@Composable
fun LoginScreen(viewModel: AuthViewModel = hiltViewModel(), navController: NavHostController) {

    LoginContent(viewModel = viewModel, navController = navController)
}

@Composable
fun LoginContent(
    viewModel: AuthViewModel,
    navController: NavHostController,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }
    val stateAuth by viewModel.authState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(stateAuth) {
        when (val auth = stateAuth) {
            is Result.Error -> {
                Toast.makeText(context, auth.errorMessage, Toast.LENGTH_SHORT).show()
                isLoading = false
            }

            Result.Loading -> {
            }

            is Result.Success -> {
                val name = auth.data.user?.displayName
                val session = AuthModel(
                    email,
                    name.toString(),
                    isLogin = true,
                    isNew = false
                )
                viewModel.saveSession(session)
                isLoading = false
                Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                navController.navigate(Screen.Home.route) {
                    popUpTo(0)
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.glass),
            contentDescription = "logo Unesco",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Text(
            text = "Login",
            fontFamily = poppinFamily,
            fontWeight = FontWeight.Medium,
            color = red,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 48.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible)
                    ImageVector.vectorResource(id = R.drawable.ic_visibility)
                else ImageVector.vectorResource(id = R.drawable.ic_visibility_off)

                IconButton(onClick = {
                    passwordVisible = !passwordVisible
                }) {
                    Icon(imageVector = image, contentDescription = null)
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                isLoading = true
                viewModel.login(email, password)
            },
            colors = ButtonDefaults.buttonColors(primary)
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    color = red,
                    modifier = Modifier.size(24.dp)
                )
            } else {
                Text(text = "Login")
            }
        }

    }
}

@Composable
@Preview
private fun Preview() {
    CocktailsAppTheme {
        LoginScreen(navController = rememberNavController())
    }
}