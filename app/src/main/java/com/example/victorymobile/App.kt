package com.example.victorymobile

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.victorymobile.ui.AppNavigation
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {}

@Composable
fun AppScreen(modifier: Modifier = Modifier) {
    AppNavigation()
}