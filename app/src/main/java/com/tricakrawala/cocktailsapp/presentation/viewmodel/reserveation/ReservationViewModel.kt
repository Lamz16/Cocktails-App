package com.tricakrawala.cocktailsapp.presentation.viewmodel.reserveation

import androidx.lifecycle.ViewModel
import com.tricakrawala.cocktailsapp.domain.usecase.CocktailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReservationViewModel @Inject constructor(private val useCase : CocktailUseCase) : ViewModel() {

}