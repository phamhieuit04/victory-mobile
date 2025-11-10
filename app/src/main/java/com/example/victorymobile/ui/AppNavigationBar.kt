package com.example.victorymobile.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.victorymobile.states.UiState
import com.example.victorymobile.ui.graphs.AboutGraph
import com.example.victorymobile.ui.graphs.CartGraph
import com.example.victorymobile.ui.graphs.HomeGraph
import com.example.victorymobile.ui.graphs.ProfileGraph
import com.example.victorymobile.ui.graphs.ShopGraph

enum class NavDestination(
    val graph: Any,
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector
) {
    HOME(HomeGraph, "Trang chủ", Icons.Outlined.Home, Icons.Default.Home),
    SHOP(ShopGraph, "Sản phẩm", Icons.Outlined.ShoppingBag, Icons.Default.ShoppingBag),
    CART(CartGraph, "Giỏ hàng", Icons.Outlined.ShoppingCart, Icons.Default.ShoppingCart),
    PROFILE(ProfileGraph, "Hồ sơ", Icons.Outlined.AccountCircle, Icons.Default.AccountCircle),
    ABOUT(AboutGraph, "Giới thiệu", Icons.Outlined.Info, Icons.Default.Info),
}

@Composable
fun AppNavigationBar(modifier: Modifier = Modifier, navController: NavController) {
    var selectedDestination by rememberSaveable { mutableIntStateOf(NavDestination.HOME.ordinal) }

    NavigationBar(
        containerColor = Color.White,
        windowInsets = NavigationBarDefaults.windowInsets
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NavDestination.entries.forEachIndexed { index, destination ->
                AppNavigationBarItem(
                    onClick = {
                        selectedDestination = index
                        navController.navigate(destination.graph) {
                            popUpTo(UiState.currentNavDestination.graph) { inclusive = true }
                        }
                        UiState.currentNavDestination = destination
                    },
                    isSelected = selectedDestination == index,
                    icon = destination.icon,
                    iconColor = Color.Black,
                    selectedIcon = destination.selectedIcon,
                    label = destination.label,
                    labelColor = Color.Black,
                )
            }
        }
    }
}

@Composable
fun AppNavigationBarItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isSelected: Boolean = false,
    icon: ImageVector,
    iconColor: Color,
    selectedIcon: ImageVector,
    label: String,
    labelColor: Color,
) {
    Surface(
        modifier = Modifier
            .widthIn(min = 64.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick
            ),
        color = Color.Transparent,
        shape = RoundedCornerShape(5.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp),
        ) {
            Icon(
                modifier = Modifier.size(26.dp),
                contentDescription = "",
                imageVector = if (isSelected) selectedIcon else icon,
                tint = if (isSelected) iconColor.copy(alpha = 0.8f) else iconColor.copy(alpha = 0.6f)
            )
            Spacer(Modifier.height(3.dp))
            Text(
                text = label,
                fontSize = 10.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) labelColor.copy(alpha = 0.8f) else labelColor.copy(alpha = 0.6f)
            )
        }
    }
}