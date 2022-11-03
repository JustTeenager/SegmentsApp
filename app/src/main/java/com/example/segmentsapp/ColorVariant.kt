package com.example.segmentsapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorVariant(
    modifier: Modifier = Modifier,
    initialGradientColors: List<Color> = listOf(),
    isSelected: Boolean = false,
    onClicked: (List<Color>) -> Unit = { _ -> },
) {

    val color = if (isSelected) Color.Gray else Color.Black

    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = 40.dp,
                minHeight = 40.dp
            )
            .clip(CircleShape)
            .border(
                width = 5.dp,
                color = color,
                shape = CircleShape
            )
            .background(
                brush = Brush.radialGradient(
                    colors = initialGradientColors
                )
            )
            .clickable { onClicked(initialGradientColors) }
    )

}