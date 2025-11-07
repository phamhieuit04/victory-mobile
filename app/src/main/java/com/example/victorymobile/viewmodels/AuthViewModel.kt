package com.example.victorymobile.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.victorymobile.contracts.repositories.AuthRepositoryInterface
import com.example.victorymobile.helpers.JsonHelper
import com.example.victorymobile.models.User
import com.example.victorymobile.states.LoginState
import com.example.victorymobile.states.SignupState
import com.example.victorymobile.states.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.call.body
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val _loginState: MutableStateFlow<LoginState>,
    private val _signupState: MutableStateFlow<SignupState>,
    private val _userState: MutableStateFlow<UserState>,
    private val authRepositoryInterface: AuthRepositoryInterface
) : ViewModel() {
    val loginState = _loginState.asStateFlow()
    val signupState = _signupState.asStateFlow()
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
                _loginState.update { state ->
                    state.copy(
                        isLoading = false
                    )
                }
                return@launch
            }
            if (response.status.value != 200) {
                val error = JsonHelper.parseString(
                    from = response.body(),
                    to = "errors",
                    key = "errors"
                )
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
                    isLoggedIn = true,
                    errorMessage = null
                )
            }
        }
    }

    fun processSignup() {
        viewModelScope.launch {
            _signupState.update { state ->
                state.copy(
                    isLoading = true
                )
            }

            val response = authRepositoryInterface.signup(
                name = _signupState.value.username.text.toString(),
                email = _signupState.value.email.text.toString(),
                password = _signupState.value.password.text.toString(),
                passwordConfirmation = _signupState.value.passwordConfirmation.text.toString()
            )
            if (response == null) {
                _signupState.update { state ->
                    state.copy(
                        isLoading = false
                    )
                }
                return@launch
            }
            if (response.status.value != 200) {
                val error = JsonHelper.parseString(
                    from = response.body(),
                    to = "message",
                    key = "message"
                )
                Log.i("MyApp", error.toString())
                _signupState.update { state ->
                    state.copy(
                        isLoading = false,
                        errorMessage = error
                    )
                }
                return@launch
            }

            _signupState.update { state ->
                state.copy(
                    isLoading = false,
                    isSignupDone = true,
                    errorMessage = null
                )
            }

            delay(100)
            _signupState.update { state ->
                state.copy(
                    isSignupDone = false
                )
            }
        }
    }
}