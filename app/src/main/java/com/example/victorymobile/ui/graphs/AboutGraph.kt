package com.example.victorymobile.ui.graphs

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.victorymobile.ui.screens.about.AboutScreen
import kotlinx.serialization.Serializable

@Serializable
object AboutGraph

@Serializable
object About

fun NavGraphBuilder.aboutGraph(modifier: Modifier = Modifier, navController: NavController) {
    navigation<AboutGraph>(startDestination = About) {
        composable<About> {
            AboutScreen()
        }
    }
}