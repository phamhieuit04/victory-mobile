package com.example.victorymobile.ui.components.shop

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.victorymobile.ui.screens.shop.SortBy
import kotlin.enums.EnumEntries

@Composable
fun SortByButton(
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit,
    onClickItem: () -> Unit,
    title: String = "Sắp xếp theo",
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    selected: Int,
    onSelectedChange: (Int) -> Unit,
    sortByItems: EnumEntries<SortBy>
) {
    Box() {
        OutlinedButton(
            onClick = onClickButton,
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff3449ca))
        ) {
            Text(text = title)
        }
        DropdownMenu(
            modifier = Modifier.padding(horizontal = 6.dp),
            expanded = expanded, onDismissRequest = { onExpandedChange(false) }
        ) {
            sortByItems.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = { Text(text = item.title) },
                    onClick = {
                        onClickItem()
                        onSelectedChange(index)
                    },
                    trailingIcon = {
                        if (selected == index) Icon(
                            contentDescription = "",
                            imageVector = Icons.Default.Check
                        )
                    }
                )
            }
        }
    }
}