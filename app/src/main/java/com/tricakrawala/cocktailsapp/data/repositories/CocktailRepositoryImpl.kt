package com.tricakrawala.cocktailsapp.data.repositories

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.userProfileChangeRequest
import com.tricakrawala.cocktailsapp.data.pref.AuthModel
import com.tricakrawala.cocktailsapp.data.pref.AuthPreference
import com.tricakrawala.cocktailsapp.data.resource.local.LocalDataSource
import com.tricakrawala.cocktailsapp.data.resource.local.entity.CocktailDrink
import com.tricakrawala.cocktailsapp.data.resource.remote.RemoteDataSource
import com.tricakrawala.cocktailsapp.data.resource.remote.response.DrinksItem
import com.tricakrawala.cocktailsapp.domain.repositories.ICocktailRepository
import com.tricakrawala.cocktailsapp.presentation.common.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val authPref : AuthPreference,
    private val firebaseAuth: FirebaseAuth
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
    override suspend fun saveSession(auth: AuthModel) {
        authPref.saveSession(auth)
    }

    override fun getSession(): Flow<Result<AuthModel>> = flow{
        emit(Result.Loading)
        try {
            val data = authPref.getSession().first()
            emit(Result.Success(data))
        }catch (e : Exception){
            emit(Result.Error(e.toString()))
        }
    }

    override suspend fun logout() {
        authPref.logout()
    }

    override fun login(email: String, password: String): Flow<Result<AuthResult>> = flow{
        emit(Result.Loading)
        try {
            val result = firebaseAuth.signInWithEmailAndPassword(email,password).await()
            emit(Result.Success(result))
        }catch (e : FirebaseAuthException){
            emit(Result.Error(e.toString()))
        }catch (e : Exception){
            emit(Result.Error(e.toString()))
        }
    }

    override fun register(email: String, password: String, name: String): Flow<Result<AuthResult>> = flow {
        emit(Result.Loading)
        try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email,password).await()
            val user = firebaseAuth.currentUser
            user?.let {
                val profileUpdates = userProfileChangeRequest {
                    displayName = name
                }
                it.updateProfile(profileUpdates).await()
            }
            emit(Result.Success(result))
        }catch (e : FirebaseAuthException){
            emit(Result.Error(e.toString()))
        }catch (e : Exception){
            emit(Result.Error(e.toString()))
        }
    }

}