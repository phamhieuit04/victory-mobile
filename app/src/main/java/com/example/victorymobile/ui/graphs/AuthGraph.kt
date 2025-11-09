package com.example.victorymobile.ui.graphs

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.victorymobile.ui.MainScreen
import com.example.victorymobile.ui.screens.auth.LoginScreen
import com.example.victorymobile.ui.screens.auth.SignupScreen
import kotlinx.serialization.Serializable

@Serializable
object AuthGraph

@Serializable
object Login

@Serializable
object Signup

fun NavGraphBuilder.authGraph(modifier: Modifier = Modifier, navController: NavController) {
    navigation<AuthGraph>(startDestination = Login) {
        composable<Login> {
            LoginScreen(
                onNavigateToSignUp = {
                    navController.navigate(Signup) {
                        popUpTo(Login) { inclusive = true }
                    }
                },
                onNavigateToHome = { navController.navigate(MainScreen) }
            )
        }
        composable<Signup> {
            SignupScreen(
                onNavigateToLogin = {
                    navController.navigate(Login) {
                        popUpTo(Signup) { inclusive = true }
                    }
                },
                onNavigateToHome = { navController.navigate(MainScreen) }
            )
        }
    }
}