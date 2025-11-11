package com.example.victorymobile.ui.screens.shop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.victorymobile.R
import com.example.victorymobile.models.Category
import com.example.victorymobile.models.Product
import com.example.victorymobile.ui.components.home.BasicSectionHeader
import com.example.victorymobile.ui.components.home.ProductItem
import com.example.victorymobile.ui.components.shop.CategoriesSection
import com.example.victorymobile.ui.components.shop.ShopBanner
import com.example.victorymobile.ui.components.shop.SortByButton

enum class SortBy(
    var id: Int,
    var title: String
) {
    DEFAULT(id = 0, title = "Mặc định"),
    POPULARITY(id = 1, title = "Nổi bật nhất"),
    LATEST(id = 2, title = "Mới nhất"),
    AVERAGE_RATTING(id = 3, title = "Đánh giá cao nhất"),
    PRICE_LOW_TO_HIGH(id = 4, title = "Giá: bé đến lớn"),
    PRICE_HIGH_TO_LOW(id = 5, title = "Giá: lớn đến bé")
}

@Composable
fun ShopScreen(modifier: Modifier = Modifier) {
    val listProduct = listOf(
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 5,
            price = "10.000.000đ",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max)
        ),
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 5,
            price = "10.000.000đ",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max)
        ),
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 5,
            price = "10.000.000đ",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max)
        ),
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 5,
            price = "10.000.000đ",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max)
        ),
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 5,
            price = "10.000.000đ",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max)
        ),
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 5,
            price = "10.000.000đ",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max)
        ),
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 5,
            price = "10.000.000đ",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max)
        ),
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 5,
            price = "10.000.000đ",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max)
        ),
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 5,
            price = "10.000.000đ",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max)
        )
    )
    val listCategory = listOf(
        Category(
            id = 0,
            title = "Điện thoại",
            thumbnail = painterResource(R.drawable.iphone_14_pro_in_hand)
        ),
        Category(
            id = 1,
            title = "Điện thoại",
            thumbnail = painterResource(R.drawable.iphone_14_pro_in_hand)
        ),
        Category(
            id = 2,
            title = "Điện thoại",
            thumbnail = painterResource(R.drawable.iphone_14_pro_in_hand)
        ),
        Category(
            id = 3,
            title = "Điện thoại",
            thumbnail = painterResource(R.drawable.iphone_14_pro_in_hand)
        ),
        Category(
            id = 4,
            title = "Điện thoại",
            thumbnail = painterResource(R.drawable.iphone_14_pro_in_hand)
        )
    )

    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableIntStateOf(0) }
    val sortByItems = SortBy.entries

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item(span = { GridItemSpan(2) }) {
            ShopBanner()
        }
        item(span = { GridItemSpan(2) }) {
            CategoriesSection(categories = listCategory)
        }
        item(span = { GridItemSpan(2) }) {
            BasicSectionHeader(modifier = Modifier.padding(bottom = 8.dp)) {
                SortByButton(
                    onClickButton = { expanded = !expanded },
                    onClickItem = { expanded = !expanded },
                    expanded = expanded,
                    onExpandedChange = { value ->
                        expanded = value
                    },
                    selected = selected,
                    onSelectedChange = { value ->
                        selected = value
                    },
                    sortByItems = sortByItems
                )
            }
        }
        items(listProduct) { product ->
            ProductItem(item = product)
        }
    }
}