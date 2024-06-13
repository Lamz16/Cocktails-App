package com.tricakrawala.cocktailsapp.presentation.viewmodel.detaildrink

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tricakrawala.cocktailsapp.data.resource.local.entity.CocktailDrink
import com.tricakrawala.cocktailsapp.data.resource.remote.response.DrinksItem
import com.tricakrawala.cocktailsapp.domain.usecase.CocktailUseCase
import com.tricakrawala.cocktailsapp.presentation.common.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val useCase: CocktailUseCase) : ViewModel() {

    private val _uiState: MutableStateFlow<Result<List<DrinksItem>>> = MutableStateFlow(Result.Loading)
    val uiState: MutableStateFlow<Result<List<DrinksItem>>> get() = _uiState

    private val _listFavorite : MutableStateFlow<Result<List<CocktailDrink>>> = MutableStateFlow(Result.Loading)
    val listFavorite: MutableStateFlow<Result<List<CocktailDrink>>>  get() = _listFavorite

    init {
        getAllFavorite()
    }

    fun getAllFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getAllCocktailFavorite().collect{
                _listFavorite.value = it
            }
        }
    }

    fun insertFavoriteCocktail(cocktailDrink: CocktailDrink){
      viewModelScope.launch {
          useCase.insertFavorite(cocktailDrink)
      }
    }

    fun deleteFavoriteCocktail(idDrink: String){
        viewModelScope.launch {
            useCase.deleteFavorite(idDrink)
        }
    }

    fun getDetailCocktail(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getDetailCocktail(id)
                .catch {
                    _uiState.value = Result.Error(it.message.toString())
                }.collect {
                    _uiState.value = it
                }
        }
    }
}