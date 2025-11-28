package com.example.victorymobile.ui.graphs

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.victorymobile.ui.screens.cart.CartScreen
import com.example.victorymobile.ui.screens.cart.CheckoutScreen
import kotlinx.serialization.Serializable

@Serializable
object CartGraph

@Serializable
object Cart

@Serializable
data class Checkout(var productId: Int? = null)

fun NavGraphBuilder.cartGraph(modifier: Modifier = Modifier, navController: NavController) {
    navigation<CartGraph>(startDestination = Cart) {
        composable<Cart> {
            CartScreen(
                onNavigateToProductDetail = { id ->
                    navController.navigate(ProductDetail(id = id))
                },
                onNavigateToCheckout = {
                    navController.navigate(Checkout(productId = null))
                }
            )
        }
        composable<Checkout> { entry ->
            val checkout = entry.toRoute<Checkout>()
            CheckoutScreen(
                productId = checkout.productId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}