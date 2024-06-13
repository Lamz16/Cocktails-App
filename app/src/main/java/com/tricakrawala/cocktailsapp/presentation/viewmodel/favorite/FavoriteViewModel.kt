package com.tricakrawala.cocktailsapp.presentation.viewmodel.favorite


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tricakrawala.cocktailsapp.data.resource.local.entity.CocktailDrink
import com.tricakrawala.cocktailsapp.domain.usecase.CocktailUseCase
import com.tricakrawala.cocktailsapp.presentation.common.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val useCase : CocktailUseCase) : ViewModel() {

    private val _listFavorite : MutableStateFlow<Result<List<CocktailDrink>>> = MutableStateFlow(
        Result.Loading)
    val listFavorite: StateFlow<Result<List<CocktailDrink>>> get() = _listFavorite

    private val _deleteState : MutableStateFlow<Result<Unit>> = MutableStateFlow(Result.Loading)
    val deleteState: StateFlow<Result<Unit>> get() = _deleteState

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

    fun deleteFavoriteCocktail(idDrink: String){
        viewModelScope.launch {
            _deleteState.value = Result.Loading
            try {
                _deleteState.value = Result.Success(useCase.deleteFavorite(idDrink))
            }catch (e : Exception){
                _deleteState.value = Result.Error(e.message.toString())
            }

        }
    }

}