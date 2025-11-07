package com.example.victorymobile.injects

import com.example.victorymobile.contracts.repositories.AuthRepositoryInterface
import com.example.victorymobile.repositories.auth.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(authRepository: AuthRepository): AuthRepositoryInterface
}