package com.example.victorymobile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHeader(modifier: Modifier = Modifier) {
    val searchState = rememberTextFieldState()

    Column(
        modifier = modifier
            .heightIn(min = 64.dp)
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Victory Store",
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )
            )
            IconButton(onClick = {}) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    contentDescription = "",
                    imageVector = Icons.Default.Menu
                )
            }
        }
        Spacer(Modifier.height(6.dp))
        Row(
            modifier = Modifier.height(50.dp),
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
}