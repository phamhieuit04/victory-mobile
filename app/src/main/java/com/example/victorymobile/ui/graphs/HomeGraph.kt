package com.example.victorymobile.ui.graphs

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.victorymobile.ui.screens.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeGraph

@Serializable
object Home

fun NavGraphBuilder.homeGraph(modifier: Modifier = Modifier, navController: NavController) {
    navigation<HomeGraph>(startDestination = Home) {
        composable<Home> {
            HomeScreen(
                onNavigateToProductDetail = { id ->
                    navController.navigate(ProductDetail(id = id))
                }
            )
        }
    }
}