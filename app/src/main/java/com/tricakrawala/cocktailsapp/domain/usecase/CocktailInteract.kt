package com.tricakrawala.cocktailsapp.domain.usecase

import com.tricakrawala.cocktailsapp.data.resource.remote.response.DrinksItem
import com.tricakrawala.cocktailsapp.domain.repositories.ICocktailRepository
import com.tricakrawala.cocktailsapp.presentation.common.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailInteract @Inject constructor(private val repository : ICocktailRepository) : CocktailUseCase {
    override fun getAllCocktail(): Flow<Result<List<DrinksItem>>> = repository.getAllCocktail()
    override fun getDetailCocktail(id: String): Flow<Result<List<DrinksItem>>> = repository.getDetailCocktail(id)
}