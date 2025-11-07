package com.example.victorymobile.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.victorymobile.contracts.repositories.AuthRepositoryInterface
import com.example.victorymobile.helpers.JsonHelper
import com.example.victorymobile.models.User
import com.example.victorymobile.states.LoginState
import com.example.victorymobile.states.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.call.body
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val _loginState: MutableStateFlow<LoginState>,
    private val _userState: MutableStateFlow<UserState>,
    private val authRepositoryInterface: AuthRepositoryInterface
) : ViewModel() {
    val loginState = _loginState.asStateFlow()
    val userState = _userState.asStateFlow()

    fun processLogin() {
        viewModelScope.launch {
            _loginState.update { state ->
                state.copy(
                    isLoading = true,
                    isLoggedIn = false
                )
            }

            val response = authRepositoryInterface.login(
                email = _loginState.value.email.text.toString(),
                password = _loginState.value.password.text.toString()
            )
            if (response == null) {
                return@launch
            }
            if (response.status.value != 200) {
                val error =
                    JsonHelper.parseString(from = response.body(), to = "message", key = "message")
                _loginState.update { state ->
                    state.copy(
                        isLoading = false,
                        errorMessage = error
                    )
                }
                return@launch
            }

            _userState.update { state ->
                state.copy(
                    currentUser = JsonHelper.parseJson(
                        from = response.body(),
                        to = User::class,
                        key = "user"
                    ),
                    accessToken = JsonHelper.parseString(
                        from = response.body(),
                        to = "data",
                        key = "token"
                    )
                )
            }
            _loginState.update { state ->
                state.copy(
                    isLoading = false,
                    isLoggedIn = true
                )
            }
        }
    }

    fun processSignup() {
        viewModelScope.launch {

        }
    }
}