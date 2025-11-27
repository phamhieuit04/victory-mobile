package com.example.victorymobile.ui.screens.cart

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.victorymobile.R
import com.example.victorymobile.models.Product

@Composable
fun CartScreen(modifier: Modifier = Modifier, onNavigateToProductDetail: (Int) -> Unit) {
    val topSellerProducts = listOf(
        Product(
            title = "Điện thoại samsung Galaxy S23",
            score = 4,
            description = "Điện thoại Android cao cấp với camera chất lượng và màn hình đẹp.",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max),
            backgroundColor = Color(0xffd1ecd9),
            price = "10.000.000đ"
        ),
        Product(
            title = "Điện thoại samsung Galaxy S23",
            score = 2,
            description = "Điện thoại Android cao cấp với camera chất lượng và màn hình",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max),
            backgroundColor = Color(0xffc6d8ee),
            price = "10.000.000đ"
        ),
        Product(
            title = "Điện thoại samsung Galaxy S23",
            score = 1,
            description = "Điện thoại Android cao cấp với camera chất lượng và màn hình",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max),
            backgroundColor = Color(0xfff6d5d0),
            price = "10.000.000đ"
        ),
        Product(
            title = "Điện thoại samsung Galaxy S23",
            score = 5,
            description = "Điện thoại Android cao cấp với camera chất lượng và màn hình",
            thumbnail = painterResource(R.drawable.iphone_17_pro_max),
            backgroundColor = Color(0xfffceee3),
            price = "10.000.000đ"
        ),
    )
    val selectedProduct = mutableListOf<Product>()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            itemsIndexed(topSellerProducts) { index, product ->
                var checked by remember { mutableStateOf(false) }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(color = Color.White)
                        .padding(top = 16.dp, end = 16.dp, start = 4.dp, bottom = 16.dp)
                        .clickable(
                            onClick = { onNavigateToProductDetail(index) },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        )
                ) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { value ->
                            checked = value
                            if (value) selectedProduct.add(product)
                            else selectedProduct.remove(product)
                        }
                    )

                    Spacer(Modifier.width(4.dp))

                    Image(
                        modifier = Modifier
                            .size(96.dp)
                            .clip(shape = RoundedCornerShape(6.dp)),
                        contentDescription = "",
                        painter = product.thumbnail,
                        contentScale = ContentScale.Crop
                    )

                    Spacer(Modifier.width(12.dp))

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = product.title,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Clip,
                            lineHeight = 18.sp,
                            color = Color.DarkGray.copy(alpha = 0.8f)
                        )
                        Text(
                            text = product.price,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red,
                            fontSize = 20.sp,
                            lineHeight = 20.sp
                        )

                        Spacer(Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                modifier = modifier
                                    .width(112.dp)
                                    .height(32.dp)
                                    .border(width = 1.dp, color = Color.LightGray),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                OutlinedIconButton(
                                    onClick = { },
                                    modifier = Modifier.size(18.dp),
                                    border = BorderStroke(width = 1.dp, color = Color.LightGray),
                                    shape = RectangleShape
                                ) {
                                    Icon(
                                        contentDescription = "",
                                        imageVector = Icons.Default.Remove,
                                        tint = Color.Gray
                                    )
                                }
                                Text(
                                    text = 1.toString(),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.DarkGray
                                )
                                OutlinedIconButton(
                                    onClick = { },
                                    modifier = Modifier.size(18.dp),
                                    border = BorderStroke(width = 1.dp, color = Color.LightGray),
                                    shape = RectangleShape
                                ) {
                                    Icon(
                                        contentDescription = "",
                                        imageVector = Icons.Default.Add,
                                        tint = Color.Gray
                                    )
                                }
                            }
                            IconButton(onClick = {}) {
                                Icon(
                                    contentDescription = "",
                                    imageVector = Icons.Default.Delete,
                                    tint = Color.Red
                                )
                            }
                        }
                    }
                }

                Spacer(Modifier.height(16.dp))
            }

            item {
                Spacer(Modifier.height(52.dp))
            }
        }
        ExtendedFloatingActionButton(
            modifier = Modifier
                .align(alignment = Alignment.BottomEnd)
                .padding(16.dp),
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Payment,
                    contentDescription = "",
                    tint = Color.White
                )
            },
            text = { Text(text = "Mua ngay", color = Color.White) },
            containerColor = Color(0xff2d41d9)
        )
    }
}