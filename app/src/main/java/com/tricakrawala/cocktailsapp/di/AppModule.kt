package com.tricakrawala.cocktailsapp.di

import com.tricakrawala.cocktailsapp.domain.usecase.CocktailInteract
import com.tricakrawala.cocktailsapp.domain.usecase.CocktailUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun providedCocktailUseCase(cocktailInteract : CocktailInteract): CocktailUseCase
}