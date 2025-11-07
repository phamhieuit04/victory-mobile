package com.example.victorymobile.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.victorymobile.contracts.repositories.AuthRepositoryInterface
import com.example.victorymobile.states.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val _loginState: MutableStateFlow<LoginState>,
    private val authRepositoryInterface: AuthRepositoryInterface
) : ViewModel() {

    val loginState = _loginState.asStateFlow()

    fun processLogin() {
        viewModelScope.launch {
            val result = authRepositoryInterface.login(
                email = loginState.value.email.text.toString(),
                password = loginState.value.password.text.toString()
            )
            if (result != null) {
                _loginState.update { state ->
                    state.copy(
                        isLoggedIn = true
                    )
                }
            }
        }
    }
}