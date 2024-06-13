package com.tricakrawala.cocktailsapp.data.pref

data class AuthModel(
    val email : String,
    val name : String,
    val isLogin : Boolean = true
)