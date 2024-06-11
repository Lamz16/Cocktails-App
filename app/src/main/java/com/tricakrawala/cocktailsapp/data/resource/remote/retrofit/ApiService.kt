package com.tricakrawala.cocktailsapp.data.resource.remote.retrofit

import com.tricakrawala.cocktailsapp.data.resource.remote.response.DrinksItem
import com.tricakrawala.cocktailsapp.data.resource.remote.response.GetAllResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search.php")
    suspend fun getAllCocktailA(@Query("f") letter: String = "a") : GetAllResponse

    @GET("lookup.php")
    suspend fun getDetailCocktail( @Query("i") id: String) : GetAllResponse
}