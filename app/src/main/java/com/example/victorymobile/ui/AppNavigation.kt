package com.example.victorymobile.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.victorymobile.ui.graphs.AuthGraph
import com.example.victorymobile.ui.graphs.authGraph
import com.example.victorymobile.ui.layouts.DefaultLayout
import kotlinx.serialization.Serializable

@Serializable
object MainScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AuthGraph) {
        authGraph(navController = navController)
        composable<MainScreen> {
            DefaultLayout()
        }
    }
}

sealed interface NavigationEvent {
    object NavigateToLogin : NavigationEvent
    object NavigateToHome : NavigationEvent
}