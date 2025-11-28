package com.example.victorymobile.ui.screens.cart

import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.victorymobile.R
import com.example.victorymobile.models.Product
import com.example.victorymobile.states.CartState
import com.example.victorymobile.states.UiState
import com.example.victorymobile.ui.components.form.FormTextField
import com.example.victorymobile.ui.components.form.FormTitle
import kotlinx.serialization.Serializable

@Serializable
object StepOne

@Serializable
object StepTwo

@Composable
fun CheckoutScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    productId: Int? = null
) {
    BackHandler {
        UiState.displayTopBar.value = true
        UiState.displayBottomBar.value = true
        CartState.selectedItems.clear()
        CartState.currentCart.forEach { cartItem ->
            cartItem.isSelected.value = false
        }

        onNavigateBack()
    }

    val navController = rememberNavController()
    val radioOptions = listOf("Thanh toán online", "Thanh toán khi nhận hàng (COD)")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    NavHost(navController = navController, startDestination = StepOne) {
        composable<StepOne> {
            Column(modifier = Modifier.padding(16.dp)) {
                FormTitle(title = "Thông tin giao hàng", fontSize = 32.sp)
                FormTextField(
                    state = TextFieldState(),
                    label = "Email",
                    placeholder = "example@gmail.com"
                )
                FormTextField(
                    state = TextFieldState(),
                    label = "Số điện thoại",
                    placeholder = "012345678"
                )
                FormTextField(
                    state = TextFieldState(),
                    label = "Địa chỉ",
                    placeholder = "Việt Nam, Hà Nội, Hà Đông..."
                )

                Spacer(Modifier.height(16.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Button(onClick = { navController.navigate(StepTwo) }) {
                        Text(text = "Tiếp theo")
                    }
                }
            }
        }
        composable<StepTwo> {
            Scaffold(bottomBar = {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Phương thức thanh toán",
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(Modifier.height(6.dp))

                    radioOptions.forEach { text ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .height(32.dp)
                                .selectable(
                                    selected = (text == selectedOption),
                                    onClick = { onOptionSelected(text) },
                                    role = Role.RadioButton
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (text == selectedOption),
                                onClick = null
                            )
                            Text(
                                text = text,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }

                    Spacer(Modifier.height(12.dp))

                    Text(
                        text = "Tổng giá trị: 10.000.000đ",
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(Modifier.height(12.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        onClick = { }
                    ) {
                        Text(text = "Thanh toán")
                    }
                }
            }) { padding ->
                if (productId != null) {
                    LazyColumn(
                        modifier = Modifier
                            .padding(padding)
                            .padding(horizontal = 16.dp)
                    ) {
                        item {
                            FormTitle(title = "Sản phẩm", fontSize = 32.sp)
                        }

                        item {
                            CheckoutItem(
                                cartItem = CartItem(
                                    product = Product(
                                        id = 0,
                                        title = "Điện thoại samsung Galaxy S23",
                                        score = 4,
                                        description = "Điện thoại Android cao cấp với camera chất lượng và màn hình đẹp.",
                                        backgroundColor = Color(0xffd1ecd9),
                                        price = "10.000.000đ"
                                    )
                                )
                            )
                        }
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .padding(padding)
                            .padding(horizontal = 16.dp)
                    ) {
                        item {
                            FormTitle(title = "Danh sách sản phẩm", fontSize = 32.sp)
                        }

                        itemsIndexed(CartState.selectedItems) { index, item ->
                            CheckoutItem(cartItem = item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CheckoutItem(modifier: Modifier = Modifier, cartItem: CartItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .background(color = Color.White)
            .padding(top = 16.dp, end = 16.dp, start = 4.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(96.dp)
                .clip(shape = RoundedCornerShape(6.dp)),
            contentDescription = "",
            painter = painterResource(R.drawable.iphone_17_pro_max),
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.width(12.dp))

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = cartItem.product.title,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Clip,
                lineHeight = 18.sp,
                color = Color.Black
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = "Số lượng: ${cartItem.quantity.value}",
                fontSize = 14.sp,
                lineHeight = 14.sp,
                color = Color.DarkGray.copy(alpha = 0.8f)
            )

            Spacer(Modifier.height(8.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomEnd
            ) {
                Text(
                    text = cartItem.product.price,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
            }
        }
    }

    Spacer(Modifier.height(16.dp))
}

@Preview(device = "id:pixel_3", showBackground = true, backgroundColor = 0xffffffff)
@Composable
fun Preview(modifier: Modifier = Modifier) {
    CheckoutScreen(onNavigateBack = {})
}