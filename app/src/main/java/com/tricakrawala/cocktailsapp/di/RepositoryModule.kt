package com.tricakrawala.cocktailsapp.di

import com.tricakrawala.cocktailsapp.data.repositories.CocktailRepositoryImpl
import com.tricakrawala.cocktailsapp.domain.repositories.ICocktailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(repository: CocktailRepositoryImpl): ICocktailRepository
}