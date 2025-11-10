package com.example.victorymobile.ui.graphs

import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.victorymobile.ui.AppHeader
import com.example.victorymobile.ui.screens.shop.ShopScreen
import kotlinx.serialization.Serializable

@Serializable
object ShopGraph

@Serializable
object Shop

fun NavGraphBuilder.shopGraph(modifier: Modifier = Modifier, navController: NavController) {
    navigation<ShopGraph>(startDestination = Shop) {
        composable<Shop> {
            Scaffold(topBar = { AppHeader() }) { paddingValues ->
                ShopScreen(padding = paddingValues)
            }
        }
    }
}