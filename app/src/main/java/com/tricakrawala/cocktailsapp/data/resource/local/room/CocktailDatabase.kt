package com.tricakrawala.cocktailsapp.data.resource.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tricakrawala.cocktailsapp.data.resource.local.entity.CocktailDrink

@Database(entities = [CocktailDrink::class], version = 1)
abstract class CocktailDatabase : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
}