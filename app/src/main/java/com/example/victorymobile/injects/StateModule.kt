package com.example.victorymobile.injects

import com.example.victorymobile.states.LoginState
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
}