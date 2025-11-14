package com.example.victorymobile.ui.screens.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.victorymobile.R
import com.example.victorymobile.models.Feedback
import com.example.victorymobile.models.Product
import com.example.victorymobile.ui.components.shop.ProductDetailFeedback
import com.example.victorymobile.ui.components.shop.ProductDetailFeedbackHeader
import com.example.victorymobile.ui.components.shop.ProductDetailImage
import com.example.victorymobile.ui.components.shop.ProductDetailInformation
import com.example.victorymobile.ui.components.shop.ProductDetailQuantity
import com.example.victorymobile.ui.components.shop.SimilarProducts

@Composable
fun ProductDetailScreen(
    onNavigateToProductDetail: (Int) -> Unit,
    modifier: Modifier = Modifier,
    id: Int
) {
    val product = Product(
        id = id,
        title = "NFL _The Duke_ Replica Composite Football, Official Size",
        description = "Laptop cấu hình mạnh, phù hợp chơi game AAA và xử lý đồ họa nặng.",
        score = 5,
        price = "10.000.000đ",
        thumbnail = painterResource(R.drawable.iphone_17_pro_max)
    )
    var quantity by remember { mutableIntStateOf(1) }
    val feedbacks = listOf(
        Feedback(
            id = 0,
            userName = "Nam Nguyen",
            userAvatar = painterResource(R.drawable.iphone_14_pro_in_hand),
            score = 5,
            comment = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.",
            time = "9 tháng 11 năm 2025"
        ),
        Feedback(
            id = 1,
            userName = "Nam Nguyen",
            userAvatar = painterResource(R.drawable.iphone_14_pro_in_hand),
            score = 5,
            comment = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.",
            time = "9 tháng 11 năm 2025"
        )
    )
    val similarProducts = listOf(
        Product(
            title = "Điện thoại samsung Galaxy S24",
            score = 4,
            description = "Điện thoại Android cao cấp với camera chất lượng và màn hình đẹp.",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max),
            backgroundColor = Color(0xffd1ecd9)
        ),
        Product(
            title = "Điện thoại samsung Galaxy S23",
            score = 2,
            description = "Điện thoại Android cao cấp với camera chất lượng và màn hình",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max),
            backgroundColor = Color(0xffc6d8ee)
        ),
        Product(
            title = "Điện thoại samsung Galaxy S23",
            score = 1,
            description = "Điện thoại Android cao cấp với camera chất lượng và màn hình",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max),
            backgroundColor = Color(0xfff6d5d0)
        ),
        Product(
            title = "Điện thoại samsung Galaxy S23",
            score = 5,
            description = "Điện thoại Android cao cấp với camera chất lượng và màn hình",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max),
            backgroundColor = Color(0xfffceee3)
        ),
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ProductDetailImage(painter = product.thumbnail)
        }
        item {
            ProductDetailInformation(
                title = product.title,
                score = product.score,
                price = product.price,
                description = product.description
            )
        }
        item {
            ProductDetailQuantity(
                quantity = quantity, onQuantityChange = { value ->
                    quantity = value
                })
        }
        item {
            Spacer(Modifier.height(16.dp))
            ProductDetailFeedbackHeader(totalFeedback = 10)
        }
        items(feedbacks) { feedback ->
            ProductDetailFeedback(feedback = feedback)
        }
        item {
            SimilarProducts(
                products = similarProducts,
                onNavigateToProductDetail = onNavigateToProductDetail
            )
        }
    }
}