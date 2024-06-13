package com.tricakrawala.cocktailsapp.domain.repositories

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

}