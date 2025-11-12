package com.example.victorymobile.ui.screens.shop

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.victorymobile.R
import com.example.victorymobile.models.Feedback
import com.example.victorymobile.models.Product

@Composable
fun ProductDetailScreen(modifier: Modifier = Modifier, id: Int) {
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
            score = 5,
            comment = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.",
            time = "9 tháng 11 năm 2025"
        ),
        Feedback(
            id = 1,
            userName = "Nam Nguyen",
            score = 5,
            comment = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.",
            time = "9 tháng 11 năm 2025"
        )
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
                price = product.price
            )
        }
        item {
            ProductDetailQuantity(
                quantity = quantity, onQuantityChange = { value ->
                    quantity = value
                })
        }
        items(feedbacks) { feedback ->
            ProductDetailFeedback(feedback = feedback)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(modifier: Modifier = Modifier) {
    ProductDetailScreen(id = 1)
}

@Composable
fun ProductDetailImage(modifier: Modifier = Modifier, painter: Painter) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(260.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painter,
            contentDescription = "",
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun ProductDetailInformation(
    modifier: Modifier = Modifier,
    title: String,
    score: Int,
    price: String
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row() {
                Text(text = "Thể loại: ", color = Color.Gray, fontSize = 11.sp)
                Text(
                    text = "Điện thoại",
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    fontSize = 11.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Row() {
                    for (i in 0..score) {
                        Icon(
                            modifier = Modifier.size(11.dp),
                            contentDescription = "",
                            imageVector = Icons.Default.Star,
                            tint = Color(0xffffa132)
                        )
                    }
                }
                Text(text = "$score.00", color = Color(0xff7c818b), fontSize = 11.sp)
                Text(text = "(1)", color = Color(0xff7c818b), fontSize = 11.sp)
            }
        }
        Spacer(Modifier.height(12.dp))
        Text(text = price, fontSize = 32.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ProductDetailQuantity(
    modifier: Modifier = Modifier,
    quantity: Int,
    onQuantityChange: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .border(width = 2.dp, color = Color.LightGray),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedIconButton(
            onClick = { if (quantity > 1) onQuantityChange(quantity - 1) },
            modifier = Modifier.size(28.dp),
            border = BorderStroke(width = 2.dp, color = Color.LightGray),
            shape = RectangleShape
        ) {
            Icon(contentDescription = "", imageVector = Icons.Default.Remove, tint = Color.Gray)
        }
        Text(
            text = quantity.toString(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )
        OutlinedIconButton(
            onClick = { onQuantityChange(quantity + 1) },
            modifier = Modifier.size(28.dp),
            border = BorderStroke(width = 2.dp, color = Color.LightGray),
            shape = RectangleShape
        ) {
            Icon(contentDescription = "", imageVector = Icons.Default.Add, tint = Color.Gray)
        }
    }
}

@Composable
fun ProductDetailFeedback(modifier: Modifier = Modifier, feedback: Feedback) {
//    TODO: make product detail feedback component
}