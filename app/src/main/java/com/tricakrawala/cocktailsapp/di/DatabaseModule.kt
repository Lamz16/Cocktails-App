package com.tricakrawala.cocktailsapp.di

import android.content.Context
import androidx.room.Room
import com.tricakrawala.cocktailsapp.data.resource.local.room.CocktailDao
import com.tricakrawala.cocktailsapp.data.resource.local.room.CocktailDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CocktailDatabase {
        return Room.databaseBuilder(context, CocktailDatabase::class.java, "cocktail_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideCocktailDao(database: CocktailDatabase): CocktailDao {
        return database.cocktailDao()
    }
}