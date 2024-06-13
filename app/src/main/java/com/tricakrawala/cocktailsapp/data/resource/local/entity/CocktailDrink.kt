package com.tricakrawala.cocktailsapp.data.resource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktail_drink")
data class CocktailDrink(
    @PrimaryKey
    @ColumnInfo(name = "idDrink")
    val idDrink: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "glass")
    val glass: String,
    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean
)
