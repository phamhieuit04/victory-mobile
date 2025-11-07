package com.example.victorymobile.injects

import com.example.victorymobile.states.LoginState
import com.example.victorymobile.states.SignupState
import com.example.victorymobile.states.UserState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StateModule {
    @Provides
    @Singleton
    fun provideLoginState(): MutableStateFlow<LoginState> {
        return MutableStateFlow(LoginState())
    }

    @Provides
    @Singleton
    fun provideSignupState(): MutableStateFlow<SignupState> {
        return MutableStateFlow(SignupState())
    }

    @Provides
    @Singleton
    fun provideUserState(): MutableStateFlow<UserState> {
        return MutableStateFlow(UserState())
    }
}