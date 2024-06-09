package com.tricakrawala.cocktailsapp.data.resource.remote

import com.tricakrawala.cocktailsapp.data.resource.remote.retrofit.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
){

}