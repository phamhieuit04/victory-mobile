package com.example.victorymobile.ui.graphs

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.victorymobile.ui.screens.cart.CartScreen
import kotlinx.serialization.Serializable

@Serializable
object CartGraph

@Serializable
object Cart

fun NavGraphBuilder.cartGraph(modifier: Modifier = Modifier, navController: NavController) {
    navigation<CartGraph>(startDestination = Cart) {
        composable<Cart> {
            CartScreen()
        }
    }
}