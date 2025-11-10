package com.example.victorymobile.ui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

data class SliderItem(
    var label: String = "",
    var title: String = "",
    var description: String = "",
    var image: Painter
)

@Composable
fun ImagesCarousel(modifier: Modifier = Modifier, sliderItems: List<SliderItem>) {
    val pagerState = rememberPagerState(pageCount = { sliderItems.count() })

    Box(
        modifier = modifier
            .height(200.dp)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        HorizontalPager(state = pagerState) { index ->
            CarouselItem(item = sliderItems[index])
        }
        Row(
            Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp, end = 24.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.White else Color(0xffd76d75)
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }
}