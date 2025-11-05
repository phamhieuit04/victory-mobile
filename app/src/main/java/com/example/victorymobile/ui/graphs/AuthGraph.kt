package com.example.victorymobile.ui.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.victorymobile.ui.screens.auth.LoginScreen
import kotlinx.serialization.Serializable

@Serializable
object AuthGraph

@Serializable
object Login

fun NavGraphBuilder.authGraph(modifier: Modifier = Modifier) {
    navigation<AuthGraph>(startDestination = Login) {
        composable<Login> {
            LoginScreen()
        }
    }
}