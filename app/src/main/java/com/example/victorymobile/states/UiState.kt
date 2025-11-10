package com.example.victorymobile.states

import androidx.compose.runtime.mutableStateOf
import com.example.victorymobile.ui.NavDestination

object UiState {
    var currentNavDestination = mutableStateOf(NavDestination.HOME)
}