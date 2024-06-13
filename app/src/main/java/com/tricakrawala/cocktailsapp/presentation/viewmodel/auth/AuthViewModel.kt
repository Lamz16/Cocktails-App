package com.tricakrawala.cocktailsapp.presentation.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tricakrawala.cocktailsapp.data.pref.AuthModel
import com.tricakrawala.cocktailsapp.domain.usecase.CocktailUseCase
import com.tricakrawala.cocktailsapp.presentation.common.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val useCase: CocktailUseCase) : ViewModel() {
    private val _session: MutableStateFlow<Result<AuthModel>> = MutableStateFlow(Result.Loading)
    val session: StateFlow<Result<AuthModel>> get() = _session

    init {
        getSession()
    }
    fun getSession() {
        viewModelScope.launch {
            useCase.getSession().catch {
                _session.value = Result.Error(it.message.toString())
            }
                .collect {
                    _session.value = it
                }
        }
    }

    fun saveSession(authModel: AuthModel) {
        viewModelScope.launch {
            useCase.saveSession(authModel)
        }
    }

    fun logout() {
        viewModelScope.launch {
            useCase.logout()
        }
    }

}