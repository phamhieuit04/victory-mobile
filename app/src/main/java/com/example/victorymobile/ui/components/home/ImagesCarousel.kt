package com.example.victorymobile.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.victorymobile.ui.screens.home.SliderItem

@Composable
fun ImagesCarousel(modifier: Modifier = Modifier, sliderItems: List<SliderItem>) {
    val pagerState = rememberPagerState(pageCount = { sliderItems.count() })

    Box() {
        HorizontalPager(state = pagerState) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = sliderItems[index].image,
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
                Column(modifier = Modifier.padding(start = 24.dp, top = 12.dp)) {
                    Text(
                        text = sliderItems[index].label.uppercase(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                    Spacer(Modifier.height(2.dp))
                    Text(
                        text = sliderItems[index].title,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        modifier = Modifier.width(96.dp),
                        lineHeight = 36.sp
                    )
                    Spacer(Modifier.height(2.dp))
                    Text(
                        text = sliderItems[index].description,
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 10.sp
                    )
                }
            }
        }
        Row(
            Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp, start = 24.dp),
            horizontalArrangement = Arrangement.Start
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