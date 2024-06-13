package com.tricakrawala.cocktailsapp.data.repositories

import com.tricakrawala.cocktailsapp.data.resource.local.LocalDataSource
import com.tricakrawala.cocktailsapp.data.resource.local.entity.CocktailDrink
import com.tricakrawala.cocktailsapp.data.resource.remote.RemoteDataSource
import com.tricakrawala.cocktailsapp.data.resource.remote.response.DrinksItem
import com.tricakrawala.cocktailsapp.domain.repositories.ICocktailRepository
import com.tricakrawala.cocktailsapp.presentation.common.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : ICocktailRepository {
    override fun getAllCocktail(): Flow<Result<List<DrinksItem>>> = flow{
        emit(Result.Loading)
        try {
            val response = remoteDataSource.getAllCocktailA()
            val result = response.drinks
            emit(Result.Success(result))
        }catch (e : Exception){
            emit(Result.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override fun getDetailCocktail(id: String): Flow<Result<List<DrinksItem>>> = flow{
        emit(Result.Loading)
        try {
            val response = remoteDataSource.getDetailCocktail(id)
            val result = response.drinks
            emit(Result.Success(result))
        }catch (e : Exception){
            emit(Result.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override fun getAllCocktailFavorite(): Flow<Result<List<CocktailDrink>>> = flow {
        emit(Result.Loading)
        try {
            val room = localDataSource.getAllCocktail()
            emit(Result.Success(room))
        } catch (e : Exception){
            emit(Result.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun insertFavorite(cocktailDrink: CocktailDrink) = localDataSource.insertFavoriteDrink(cocktailDrink)

    override suspend fun deleteFavorite(idDrink: String) = localDataSource.deleteFavoriteDrink(idDrink)


}