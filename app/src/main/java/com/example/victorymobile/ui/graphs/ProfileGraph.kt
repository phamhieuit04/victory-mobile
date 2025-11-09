package com.example.victorymobile.ui.graphs

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.victorymobile.ui.screens.profile.ProfileScreen
import kotlinx.serialization.Serializable

@Serializable
object ProfileGraph

@Serializable
object Profile

fun NavGraphBuilder.profileGraph(modifier: Modifier = Modifier, navController: NavController) {
    navigation<ProfileGraph>(startDestination = Profile) {
        composable<Profile> {
            ProfileScreen()
        }
    }
}