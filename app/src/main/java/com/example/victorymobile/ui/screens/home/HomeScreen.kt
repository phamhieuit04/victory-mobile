package com.example.victorymobile.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.victorymobile.R
import com.example.victorymobile.ui.components.home.ImagesCarousel

data class SliderItem(
    var label: String = "",
    var title: String = "",
    var description: String = "",
    var image: Painter
)

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val sliderItems = listOf(
        SliderItem(
            label = "New Arrivals",
            title = "Hot Right Now",
            description = "Retro Remixed For The Future\nFuture starting at 100$",
            image = painterResource(R.drawable.homev1_slider01_1)
        ),
        SliderItem(
            label = "New Arrivals",
            title = "Hot Right Now",
            description = "Retro Remixed For The Future\nFuture starting at 100$",
            image = painterResource(R.drawable.homev1_slider01_1)
        ),
        SliderItem(
            label = "New Arrivals",
            title = "Hot Right Now",
            description = "Retro Remixed For The Future\nFuture starting at 100$",
            image = painterResource(R.drawable.homev1_slider01_1)
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(state = rememberScrollState())
    ) {
        ImagesCarousel(sliderItems = sliderItems)
    }
}

@Preview
@Composable
fun Preview(modifier: Modifier = Modifier) {
    HomeScreen()
}