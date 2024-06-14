package com.tricakrawala.cocktailsapp.domain.usecase

import com.google.firebase.auth.AuthResult
import com.tricakrawala.cocktailsapp.data.pref.AuthModel
import com.tricakrawala.cocktailsapp.data.resource.local.entity.CocktailDrink
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
    override fun getAllCocktailFavorite(): Flow<Result<List<CocktailDrink>>> = repository.getAllCocktailFavorite()

    override suspend fun insertFavorite(cocktailDrink: CocktailDrink) = repository.insertFavorite(cocktailDrink)

    override suspend fun deleteFavorite(idDrink: String) = repository.deleteFavorite(idDrink)
    override suspend fun saveSession(auth: AuthModel) = repository.saveSession(auth)

    override fun getSession(): Flow<Result<AuthModel>> = repository.getSession()

    override suspend fun logout() = repository.logout()
    override fun login(email: String, password: String): Flow<Result<AuthResult>> = repository.login(email, password)

    override fun register(email: String, password: String, name: String): Flow<Result<AuthResult>> = repository.register(email, password, name)
}