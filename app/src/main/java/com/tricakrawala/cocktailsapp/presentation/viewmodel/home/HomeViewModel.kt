package com.tricakrawala.cocktailsapp.presentation.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tricakrawala.cocktailsapp.data.resource.remote.response.DrinksItem
import com.tricakrawala.cocktailsapp.domain.usecase.CocktailUseCase
import com.tricakrawala.cocktailsapp.presentation.common.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: CocktailUseCase) : ViewModel() {
    private val _uiState : MutableStateFlow<Result<List<DrinksItem>>> = MutableStateFlow(Result.Loading)
    val uiState : StateFlow<Result<List<DrinksItem>>> get() = _uiState

    init {
        getAllCocktails()
    }

    private fun getAllCocktails(){
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getAllCocktail()
                .catch {
                    _uiState.value = Result.Error(it.message.toString())
                }
                .collect{
                    _uiState.value = it
                }
        }
    }
}