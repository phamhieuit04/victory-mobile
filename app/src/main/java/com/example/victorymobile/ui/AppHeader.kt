package com.example.victorymobile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.victorymobile.states.UiState
import com.example.victorymobile.ui.components.header.HeaderSearchBar
import com.example.victorymobile.ui.components.header.MainHeader

@Composable
fun AppHeader(modifier: Modifier = Modifier) {
    val searchState = rememberTextFieldState()
    var canDisplaySearchBar by remember { mutableStateOf(true) }

    LaunchedEffect(UiState.currentNavDestination.value) {
        canDisplaySearchBar = when (UiState.currentNavDestination.value) {
            NavDestination.HOME -> true
            NavDestination.SHOP -> true
            NavDestination.CART -> false
            NavDestination.PROFILE -> false
            NavDestination.ABOUT -> false
        }
    }

    Column(
        modifier = modifier
            .heightIn(min = 64.dp)
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp)
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainHeader()
        if (canDisplaySearchBar) HeaderSearchBar(searchState = searchState)
    }
}

@Preview
@Composable
fun Preview(modifier: Modifier = Modifier) {
    AppHeader()
}