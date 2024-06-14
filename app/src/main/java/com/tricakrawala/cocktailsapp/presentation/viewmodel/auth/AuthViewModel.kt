package com.tricakrawala.cocktailsapp.presentation.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult
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

    private val _authState: MutableStateFlow<Result<AuthResult>> = MutableStateFlow(Result.Loading)
    val authState: StateFlow<Result<AuthResult>> get() = _authState


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
            getSession()
        }
    }

    fun logout() {
        viewModelScope.launch {
            useCase.logout()
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            useCase.login(email, password).catch {
                _authState.value = Result.Error(it.message.toString())
            }.collect {
                _authState.value = it
            }
        }
    }

    fun register(email: String, password: String, name: String) = viewModelScope.launch {
        useCase.register(email, password, name).catch {
            _authState.value = Result.Error(it.message.toString())
        }.collect {
            _authState.value = it
        }
    }

}