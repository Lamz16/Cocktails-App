package com.tricakrawala.cocktailsapp.data.resource.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tricakrawala.cocktailsapp.data.resource.local.entity.CocktailDrink

@Dao
interface CocktailDao {

    @Insert
    suspend fun insertFavoriteDrink(drink: CocktailDrink)

    @Query("SELECT * FROM cocktail_drink")
    fun getAllCocktails(): List<CocktailDrink>

    @Query("DELETE FROM cocktail_drink WHERE idDrink = :idDrink")
    suspend fun deleteFavorite(idDrink : String)
}