package com.example.victorymobile.ui.layouts

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.victorymobile.ui.AppHeader
import com.example.victorymobile.ui.AppNavigationBar
import com.example.victorymobile.ui.graphs.HomeGraph
import com.example.victorymobile.ui.graphs.aboutGraph
import com.example.victorymobile.ui.graphs.cartGraph
import com.example.victorymobile.ui.graphs.homeGraph
import com.example.victorymobile.ui.graphs.profileGraph
import com.example.victorymobile.ui.graphs.shopGraph

@Composable
fun DefaultLayout(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        topBar = { AppHeader() },
        bottomBar = { AppNavigationBar(navController = navController) }
    ) { padding ->
        NavHost(
            modifier = Modifier.padding(paddingValues = padding),
            navController = navController,
            startDestination = HomeGraph
        ) {
            homeGraph(navController = navController)
            shopGraph(navController = navController)
            cartGraph(navController = navController)
            profileGraph(navController = navController)
            aboutGraph(navController = navController)
        }
    }
}