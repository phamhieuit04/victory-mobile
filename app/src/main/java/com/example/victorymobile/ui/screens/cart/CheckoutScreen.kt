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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    val listProduct = listOf(
        Product(
            id = 0,
            title = "Laptop Gaming Asus ROG",
            description = "Chiếc laptop này được trang bị cấu hình mạnh mẽ với CPU đa nhân hiệu suất cao, kết hợp cùng card đồ họa rời thế hệ mới giúp xử lý mượt mà các tựa game AAA, phần mềm đồ họa 3D và ứng dụng mô phỏng nặng. Máy sở hữu bộ nhớ RAM dung lượng lớn cho khả năng đa nhiệm ổn định, ổ cứng SSD tốc độ cao mang lại thời gian khởi động cực nhanh và mở ứng dụng gần như tức thì. Hệ thống tản nhiệt được tối ưu giúp duy trì hiệu suất trong thời gian dài mà không gây nóng quá mức. Thiết kế hiện đại, chắc chắn, màn hình độ phân giải cao hỗ trợ dải màu rộng, phù hợp cả cho game thủ lẫn người làm sáng tạo nội dung.",
            score = 4,
            price = "25.000.000đ",
            thumbnail = painterResource(R.drawable.product_1)
        ),
        Product(
            id = 1,
            title = "Laptop Dell Inspiron",
            description = "Laptop hướng đến nhu cầu văn phòng với thiết kế bền bỉ, trọng lượng nhẹ và thời lượng pin vượt trội, giúp người dùng làm việc liên tục nhiều giờ mà không cần sạc. Máy được trang bị bộ vi xử lý tiết kiệm điện nhưng vẫn đủ mạnh để xử lý các ứng dụng văn phòng, họp online và duyệt web mượt mà. Bàn phím êm, hành trình phím tốt hỗ trợ gõ lâu không mỏi tay. SSD cho tốc độ phản hồi nhanh và độ ổn định cao. Thiết bị cũng tối ưu khả năng kết nối với nhiều cổng thông dụng phục vụ học tập, làm việc từ xa, phù hợp với sinh viên, nhân viên văn phòng và người cần một chiếc máy tính đáng tin cậy.",
            score = 2,
            price = "15.000.000đ",
            thumbnail = painterResource(R.drawable.product_2)
        ),
        Product(
            id = 2,
            title = "Điện thoại Samsung Galaxy S23",
            description = "Điện thoại Android cao cấp sở hữu hệ thống camera chất lượng với cảm biến lớn, khả năng chụp đêm ấn tượng và nhiều chế độ xử lý ảnh thông minh. Màn hình sắc nét, tần số quét cao đem lại trải nghiệm giải trí mượt mà khi chơi game hoặc xem phim. Chip xử lý mạnh giúp chạy đa nhiệm tốt, kết hợp dung lượng pin lớn và sạc nhanh cho phép sử dụng cả ngày dài. Hệ điều hành Android linh hoạt, dễ tùy biến theo nhu cầu cá nhân. Máy cũng hỗ trợ nhiều công nghệ hiện đại như mở khóa sinh trắc học, kết nối 5G và âm thanh sống động, phù hợp cho người dùng yêu thích trải nghiệm toàn diện.",
            score = 1,
            price = "18.000.000đ",
            thumbnail = painterResource(R.drawable.product_3)
        ),
        Product(
            id = 3,
            title = "Điện thoại iPhone 14",
            description = "Điện thoại iOS mang đến hiệu năng mạnh mẽ nhờ chip xử lý tối ưu, kết hợp hệ điều hành ổn định và mượt mà. Thiết kế tinh tế, hoàn thiện cao cấp cùng khả năng bảo mật nổi tiếng giúp bảo vệ dữ liệu cá nhân tốt hơn. Camera được tối ưu thuật toán, cho màu sắc tự nhiên và quay video chất lượng cao. Màn hình sắc nét, độ sáng cao, hiển thị tốt ngay cả dưới ánh nắng. Hệ sinh thái iOS cho phép đồng bộ liền mạch với các thiết bị khác, tạo nên trải nghiệm tiện lợi trong công việc và giải trí. Pin ổn định, sạc nhanh, phù hợp người dùng thích sự đơn giản nhưng hiệu quả.",
            score = 5,
            price = "22.000.000đ",
            thumbnail = painterResource(R.drawable.product_4)
        ),
        Product(
            id = 4,
            title = "Laptop Gaming Asus ROG",
            description = "Điện thoại iOS mang đến hiệu năng mạnh mẽ nhờ chip xử lý tối ưu, kết hợp hệ điều hành ổn định và mượt mà. Thiết kế tinh tế, hoàn thiện cao cấp cùng khả năng bảo mật nổi tiếng giúp bảo vệ dữ liệu cá nhân tốt hơn. Camera được tối ưu thuật toán, cho màu sắc tự nhiên và quay video chất lượng cao. Màn hình sắc nét, độ sáng cao, hiển thị tốt ngay cả dưới ánh nắng. Hệ sinh thái iOS cho phép đồng bộ liền mạch với các thiết bị khác, tạo nên trải nghiệm tiện lợi trong công việc và giải trí. Pin ổn định, sạc nhanh, phù hợp người dùng thích sự đơn giản nhưng hiệu quả.",
            score = 4,
            price = "25.000.000đ",
            thumbnail = painterResource(R.drawable.product_1)
        ),
        Product(
            id = 5,
            title = "Laptop Dell Inspiron",
            description = "Điện thoại Android cao cấp sở hữu hệ thống camera chất lượng với cảm biến lớn, khả năng chụp đêm ấn tượng và nhiều chế độ xử lý ảnh thông minh. Màn hình sắc nét, tần số quét cao đem lại trải nghiệm giải trí mượt mà khi chơi game hoặc xem phim. Chip xử lý mạnh giúp chạy đa nhiệm tốt, kết hợp dung lượng pin lớn và sạc nhanh cho phép sử dụng cả ngày dài. Hệ điều hành Android linh hoạt, dễ tùy biến theo nhu cầu cá nhân. Máy cũng hỗ trợ nhiều công nghệ hiện đại như mở khóa sinh trắc học, kết nối 5G và âm thanh sống động, phù hợp cho người dùng yêu thích trải nghiệm toàn diện.",
            score = 2,
            price = "15.000.000đ",
            thumbnail = painterResource(R.drawable.product_2)
        ),
        Product(
            id = 6,
            title = "Điện thoại Samsung Galaxy S23",
            description = "Điện thoại iOS mang đến hiệu năng mạnh mẽ nhờ chip xử lý tối ưu, kết hợp hệ điều hành ổn định và mượt mà. Thiết kế tinh tế, hoàn thiện cao cấp cùng khả năng bảo mật nổi tiếng giúp bảo vệ dữ liệu cá nhân tốt hơn. Camera được tối ưu thuật toán, cho màu sắc tự nhiên và quay video chất lượng cao. Màn hình sắc nét, độ sáng cao, hiển thị tốt ngay cả dưới ánh nắng. Hệ sinh thái iOS cho phép đồng bộ liền mạch với các thiết bị khác, tạo nên trải nghiệm tiện lợi trong công việc và giải trí. Pin ổn định, sạc nhanh, phù hợp người dùng thích sự đơn giản nhưng hiệu quả.",
            score = 1,
            price = "18.000.000đ",
            thumbnail = painterResource(R.drawable.product_3)
        ),
        Product(
            id = 7,
            description = "Điện thoại Android cao cấp sở hữu hệ thống camera chất lượng với cảm biến lớn, khả năng chụp đêm ấn tượng và nhiều chế độ xử lý ảnh thông minh. Màn hình sắc nét, tần số quét cao đem lại trải nghiệm giải trí mượt mà khi chơi game hoặc xem phim. Chip xử lý mạnh giúp chạy đa nhiệm tốt, kết hợp dung lượng pin lớn và sạc nhanh cho phép sử dụng cả ngày dài. Hệ điều hành Android linh hoạt, dễ tùy biến theo nhu cầu cá nhân. Máy cũng hỗ trợ nhiều công nghệ hiện đại như mở khóa sinh trắc học, kết nối 5G và âm thanh sống động, phù hợp cho người dùng yêu thích trải nghiệm toàn diện.",
            title = "Điện thoại iPhone 14",
            score = 5,
            price = "22.000.000đ",
            thumbnail = painterResource(R.drawable.product_4)
        ),
        Product(
            id = 8,
            title = "Laptop Gaming Asus ROG",
            description = "Chiếc laptop này được trang bị cấu hình mạnh mẽ với CPU đa nhân hiệu suất cao, kết hợp cùng card đồ họa rời thế hệ mới giúp xử lý mượt mà các tựa game AAA, phần mềm đồ họa 3D và ứng dụng mô phỏng nặng. Máy sở hữu bộ nhớ RAM dung lượng lớn cho khả năng đa nhiệm ổn định, ổ cứng SSD tốc độ cao mang lại thời gian khởi động cực nhanh và mở ứng dụng gần như tức thì. Hệ thống tản nhiệt được tối ưu giúp duy trì hiệu suất trong thời gian dài mà không gây nóng quá mức. Thiết kế hiện đại, chắc chắn, màn hình độ phân giải cao hỗ trợ dải màu rộng, phù hợp cả cho game thủ lẫn người làm sáng tạo nội dung.",
            score = 4,
            price = "25.000.000đ",
            thumbnail = painterResource(R.drawable.product_1)
        )
    )
    var totalPrice by remember { mutableStateOf("") }

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
                        text = "Tổng giá trị: $totalPrice",
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
                    val product = listProduct.first { it.id == productId }
                    totalPrice = product.price;

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
                                    product = product
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
        cartItem.product.thumbnail?.let {
            Image(
                modifier = Modifier
                    .size(96.dp)
                    .clip(shape = RoundedCornerShape(6.dp)),
                contentDescription = "",
                painter = it,
                contentScale = ContentScale.Crop
            )
        }

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
                overflow = TextOverflow.Ellipsis,
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