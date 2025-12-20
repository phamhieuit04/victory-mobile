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
import com.example.victorymobile.states.CartState
import com.example.victorymobile.states.UiState
import com.example.victorymobile.ui.components.shop.ProductDetailButtons
import com.example.victorymobile.ui.components.shop.ProductDetailFeedback
import com.example.victorymobile.ui.components.shop.ProductDetailFeedbackHeader
import com.example.victorymobile.ui.components.shop.ProductDetailImage
import com.example.victorymobile.ui.components.shop.ProductDetailInformation
import com.example.victorymobile.ui.components.shop.ProductDetailQuantity
import com.example.victorymobile.ui.components.shop.SimilarProducts
import com.example.victorymobile.ui.screens.cart.CartItem

@Composable
fun ProductDetailScreen(
    onNavigateToProductDetail: (Int) -> Unit,
    onNavigateToCheckout: (Int) -> Unit,
    modifier: Modifier = Modifier,
    id: Int
) {
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
    val product = listProduct.first { it.id == id }
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
            userAvatar = painterResource(R.drawable.product_3),
            score = 5,
            comment = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.",
            time = "9 tháng 11 năm 2025"
        )
    )
    val similarProducts = listOf(
        Product(
            title = "Laptop Gaming Asus ROG",
            score = 4,
            description = "Chiếc laptop này được trang bị cấu hình mạnh mẽ với CPU đa nhân hiệu suất cao, kết hợp cùng card đồ họa rời thế hệ mới giúp xử lý mượt mà các tựa game AAA, phần mềm đồ họa 3D và ứng dụng mô phỏng nặng. Máy sở hữu bộ nhớ RAM dung lượng lớn cho khả năng đa nhiệm ổn định, ổ cứng SSD tốc độ cao mang lại thời gian khởi động cực nhanh và mở ứng dụng gần như tức thì. Hệ thống tản nhiệt được tối ưu giúp duy trì hiệu suất trong thời gian dài mà không gây nóng quá mức. Thiết kế hiện đại, chắc chắn, màn hình độ phân giải cao hỗ trợ dải màu rộng, phù hợp cả cho game thủ lẫn người làm sáng tạo nội dung.",
            thumbnail = painterResource(R.drawable.product_1),
            backgroundColor = Color(0xffd1ecd9)
        ),
        Product(
            title = "Laptop Dell Inspiron",
            score = 2,
            description = "Laptop hướng đến nhu cầu văn phòng với thiết kế bền bỉ, trọng lượng nhẹ và thời lượng pin vượt trội, giúp người dùng làm việc liên tục nhiều giờ mà không cần sạc. Máy được trang bị bộ vi xử lý tiết kiệm điện nhưng vẫn đủ mạnh để xử lý các ứng dụng văn phòng, họp online và duyệt web mượt mà. Bàn phím êm, hành trình phím tốt hỗ trợ gõ lâu không mỏi tay. SSD cho tốc độ phản hồi nhanh và độ ổn định cao. Thiết bị cũng tối ưu khả năng kết nối với nhiều cổng thông dụng phục vụ học tập, làm việc từ xa, phù hợp với sinh viên, nhân viên văn phòng và người cần một chiếc máy tính đáng tin cậy.",
            thumbnail = painterResource(R.drawable.product_2),
            backgroundColor = Color(0xffc6d8ee)
        ),
        Product(
            title = "Điện thoại Samsung Galaxy S23",
            score = 1,
            description = "Điện thoại Android cao cấp sở hữu hệ thống camera chất lượng với cảm biến lớn, khả năng chụp đêm ấn tượng và nhiều chế độ xử lý ảnh thông minh. Màn hình sắc nét, tần số quét cao đem lại trải nghiệm giải trí mượt mà khi chơi game hoặc xem phim. Chip xử lý mạnh giúp chạy đa nhiệm tốt, kết hợp dung lượng pin lớn và sạc nhanh cho phép sử dụng cả ngày dài. Hệ điều hành Android linh hoạt, dễ tùy biến theo nhu cầu cá nhân. Máy cũng hỗ trợ nhiều công nghệ hiện đại như mở khóa sinh trắc học, kết nối 5G và âm thanh sống động, phù hợp cho người dùng yêu thích trải nghiệm toàn diện.",
            thumbnail = painterResource(R.drawable.product_3),
            backgroundColor = Color(0xfff6d5d0)
        ),
        Product(
            title = "Điện thoại iPhone 14",
            score = 5,
            description = "Điện thoại iOS mang đến hiệu năng mạnh mẽ nhờ chip xử lý tối ưu, kết hợp hệ điều hành ổn định và mượt mà. Thiết kế tinh tế, hoàn thiện cao cấp cùng khả năng bảo mật nổi tiếng giúp bảo vệ dữ liệu cá nhân tốt hơn. Camera được tối ưu thuật toán, cho màu sắc tự nhiên và quay video chất lượng cao. Màn hình sắc nét, độ sáng cao, hiển thị tốt ngay cả dưới ánh nắng. Hệ sinh thái iOS cho phép đồng bộ liền mạch với các thiết bị khác, tạo nên trải nghiệm tiện lợi trong công việc và giải trí. Pin ổn định, sạc nhanh, phù hợp người dùng thích sự đơn giản nhưng hiệu quả.",
            thumbnail = painterResource(R.drawable.product_4),
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
            ProductDetailButtons(
                onAddToCart = {
                    CartState.currentCart.add(
                        CartItem(
                            quantity = mutableIntStateOf(quantity),
                            product = product
                        )
                    )
                },
                onNavigateToCheckout = {
                    UiState.displayTopBar.value = false
                    UiState.displayBottomBar.value = false
                    onNavigateToCheckout(product.id)
                }
            )
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