package com.tricakrawala.cocktailsapp.domain.repositories

import com.google.firebase.auth.AuthResult
import com.tricakrawala.cocktailsapp.data.pref.AuthModel
import com.tricakrawala.cocktailsapp.data.resource.local.entity.CocktailDrink
import com.tricakrawala.cocktailsapp.data.resource.remote.response.DrinksItem
import com.tricakrawala.cocktailsapp.presentation.common.Result
import kotlinx.coroutines.flow.Flow

interface ICocktailRepository {
    fun getAllCocktail() : Flow<Result<List<DrinksItem>>>

    fun getDetailCocktail(id : String) : Flow<Result<List<DrinksItem>>>

    fun getAllCocktailFavorite() : Flow<Result<List<CocktailDrink>>>

    suspend fun insertFavorite(cocktailDrink: CocktailDrink)

    suspend fun deleteFavorite(idDrink: String)

    suspend fun saveSession(auth : AuthModel)
    fun getSession(): Flow<Result<AuthModel>>
    suspend fun logout()

    fun login(email: String, password: String) : Flow<Result<AuthResult>>
    fun register(email: String, password: String,name : String) : Flow<Result<AuthResult>>


}