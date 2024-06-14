package com.tricakrawala.cocktailsapp.presentation.common

data class SignInState(
    val isLoading : Boolean = false,
    val signInSuccess : String? = "",
    val signInError : String? = ""
)
