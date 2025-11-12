package com.example.victorymobile.ui.graphs

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.victorymobile.ui.screens.shop.ProductDetailScreen
import com.example.victorymobile.ui.screens.shop.ShopScreen
import kotlinx.serialization.Serializable

@Serializable
object ShopGraph

@Serializable
object Shop

@Serializable
data class ProductDetail(var id: Int)

fun NavGraphBuilder.shopGraph(modifier: Modifier = Modifier, navController: NavController) {
    navigation<ShopGraph>(startDestination = Shop) {
        composable<Shop> {
            ShopScreen(
                onNavigateToProductDetail = { id ->
                    navController.navigate(ProductDetail(id = id))
                }
            )
        }
        composable<ProductDetail> { entry ->
            val productDetail = entry.toRoute<ProductDetail>()
            ProductDetailScreen(id = productDetail.id)
        }
    }
}