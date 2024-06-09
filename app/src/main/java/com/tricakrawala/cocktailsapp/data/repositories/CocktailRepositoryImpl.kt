package com.tricakrawala.cocktailsapp.data.repositories

import com.tricakrawala.cocktailsapp.data.resource.remote.RemoteDataSource
import com.tricakrawala.cocktailsapp.domain.repositories.ICocktailRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ICocktailRepository {

}