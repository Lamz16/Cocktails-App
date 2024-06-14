package com.tricakrawala.cocktailsapp.presentation.viewmodel.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tricakrawala.cocktailsapp.data.DataTeam
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
class AboutViewModel @Inject constructor(private val useCase: CocktailUseCase) : ViewModel() {
    private val _listTeam: MutableStateFlow<Result<List<DataTeam>>> = MutableStateFlow(
        Result.Loading
    )
    val listTeam: StateFlow<Result<List<DataTeam>>> get() = _listTeam

    }
