package com.tricakrawala.cocktailsapp.data.resource.local

import com.tricakrawala.cocktailsapp.data.resource.local.entity.CocktailDrink
import com.tricakrawala.cocktailsapp.data.resource.local.room.CocktailDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val cocktailDao: CocktailDao) {

    suspend fun insertFavoriteDrink(drink : CocktailDrink) = cocktailDao.insertFavoriteDrink(drink)

    fun getAllCocktail() = cocktailDao.getAllCocktails()

    suspend fun deleteFavoriteDrink(idDrink : String) = cocktailDao.deleteFavorite(idDrink)
}