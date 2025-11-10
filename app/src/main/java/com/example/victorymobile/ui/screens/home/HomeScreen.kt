package com.example.victorymobile.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.victorymobile.R
import com.example.victorymobile.models.Product
import com.example.victorymobile.ui.components.home.ImagesCarousel
import com.example.victorymobile.ui.components.home.ListProduct
import com.example.victorymobile.ui.components.home.TopSellers

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
    val topSellerProducts = listOf(
        Product(
            title = "Điện thoại samsung Galaxy S23",
            score = 4,
            description = "Điện thoại Android cao cấp với camera chất lượng và màn hình đẹp.",
            image = painterResource(R.drawable.iphone_17_pro_max),
            backgroundColor = Color(0xffd1ecd9)
        ),
        Product(
            title = "Điện thoại samsung Galaxy S23",
            score = 2,
            description = "Điện thoại Android cao cấp với camera chất lượng và màn hình",
            image = painterResource(R.drawable.iphone_17_pro_max),
            backgroundColor = Color(0xffc6d8ee)
        ),
        Product(
            title = "Điện thoại samsung Galaxy S23",
            score = 1,
            description = "Điện thoại Android cao cấp với camera chất lượng và màn hình",
            image = painterResource(R.drawable.iphone_17_pro_max),
            backgroundColor = Color(0xfff6d5d0)
        ),
        Product(
            title = "Điện thoại samsung Galaxy S23",
            score = 5,
            description = "Điện thoại Android cao cấp với camera chất lượng và màn hình",
            image = painterResource(R.drawable.iphone_17_pro_max),
            backgroundColor = Color(0xfffceee3)
        ),
    )
    val outstandingProduct = listOf(
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 5,
            price = "10.000.000đ",
            image = painterResource(R.drawable.iphone_17_pro_max)
        ),
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 5,
            price = "10.000.000đ",
            image = painterResource(R.drawable.iphone_17_pro_max)
        ),
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 5,
            price = "10.000.000đ",
            image = painterResource(R.drawable.iphone_17_pro_max)
        ),
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 5,
            price = "10.000.000đ",
            image = painterResource(R.drawable.iphone_17_pro_max)
        ),
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 5,
            price = "10.000.000đ",
            image = painterResource(R.drawable.iphone_17_pro_max)
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        ImagesCarousel(sliderItems = sliderItems)
        Spacer(Modifier.height(18.dp))

        TopSellers(topSellerProducts = topSellerProducts)
        Spacer(Modifier.height(18.dp))

        ListProduct(products = outstandingProduct)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(modifier: Modifier = Modifier) {
    HomeScreen()
}