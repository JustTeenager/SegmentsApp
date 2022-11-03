package com.example.segmentsapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InteractiveIndicator(
    modifier: Modifier = Modifier,
    viewModel: InteractiveIndicatorViewModel = InteractiveIndicatorViewModel()
) {
    var currentColorGradient by remember {
        mutableStateOf(blueGradient)
    }

    var numberText by remember {
        mutableStateOf(viewModel.getNumberText())
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier,
            text = "Текущая цифра:",
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp,
            color = Color.Black
        )

        Text(
            modifier = Modifier,
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ColorPicker(
                modifier = Modifier
            ) {
                currentColorGradient = it
            }

            Spacer(modifier = Modifier.width(40.dp))

            SegmentIndicator(
                modifier = Modifier,
                gradientColors = currentColorGradient
            ) { num, isSelected ->
                viewModel.updateSegment(num, isSelected)
                numberText = viewModel.getNumberText()
            }
        }
    }
}