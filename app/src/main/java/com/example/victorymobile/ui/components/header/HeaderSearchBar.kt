package com.example.victorymobile.ui.components.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HeaderSearchBar(modifier: Modifier = Modifier, searchState: TextFieldState) {
    Spacer(Modifier.height(6.dp))
    Row(
        modifier = modifier.height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        BasicTextField(
            modifier = Modifier.weight(1f),
            state = searchState,
            lineLimits = TextFieldLineLimits.SingleLine,
            decorator = { innerTextField ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .shadow(6.dp)
                        .background(Color.White)
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    if (searchState.text.isEmpty()) Text(
                        text = "Nhập để tìm kiếm",
                        color = Color.Black.copy(alpha = 0.4f),
                        fontWeight = FontWeight.Bold
                    )
                    innerTextField()
                }
            }
        )
        IconButton(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .shadow(12.dp),
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color(0xff3449ca),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(3.dp)
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                contentDescription = "", imageVector = Icons.Default.Search
            )
        }
    }
}