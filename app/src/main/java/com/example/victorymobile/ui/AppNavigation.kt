package com.example.victorymobile.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.victorymobile.ui.graphs.AuthGraph
import com.example.victorymobile.ui.graphs.authGraph

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AuthGraph) {
        authGraph()
    }
}