package com.example.victorymobile.ui.components.shop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.victorymobile.models.Category

@Composable
fun CategoriesSection(modifier: Modifier = Modifier, categories: List<Category>) {
    var selected by remember { mutableIntStateOf(-1) }

    LazyRow(
        modifier = modifier.height(70.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(categories) { index, category ->
            OutlinedButton(
                onClick = { selected = index },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selected == index) Color(0xff3449ca) else Color.Transparent,
                    contentColor = if (selected == index) Color.White else Color.Black
                )
            ) {
                Text(text = category.title)
            }
        }
    }
}