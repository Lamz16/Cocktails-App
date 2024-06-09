package com.tricakrawala.cocktailsapp.domain.usecase

import com.tricakrawala.cocktailsapp.domain.repositories.ICocktailRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailInteract @Inject constructor(private val repository : ICocktailRepository) : CocktailUseCase {

}