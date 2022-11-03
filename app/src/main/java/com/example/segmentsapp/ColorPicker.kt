package com.example.segmentsapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorPicker(
    modifier: Modifier = Modifier,
    onColorChosen: (List<Color>) -> Unit
) {

    var currentSelectedColorGradient by remember {
        mutableStateOf(blueGradient)
    }

    Column(modifier = modifier) {

        ColorVariant(
            modifier = Modifier.wrapContentSize(),
            initialGradientColors = listOf(Color(0xFF6D6DFF), Color.Blue),
            isSelected = currentSelectedColorGradient == blueGradient,
            onClicked = { colorGradient ->
                currentSelectedColorGradient = colorGradient
                onColorChosen(colorGradient)
            }
        )

        Spacer(modifier = Modifier.height(25.dp))


        ColorVariant(
            modifier = Modifier.wrapContentSize(),
            initialGradientColors = pinkGradient,
            isSelected = currentSelectedColorGradient == pinkGradient,
            onClicked = { colorGradient ->
                currentSelectedColorGradient = colorGradient
                onColorChosen(colorGradient)
            }
        )

        Spacer(modifier = Modifier.height(25.dp))

        ColorVariant(
            modifier = Modifier.wrapContentSize(),
            initialGradientColors = greenGradient,
            isSelected = currentSelectedColorGradient == greenGradient,
            onClicked = { colorGradient ->
                currentSelectedColorGradient = colorGradient
                onColorChosen(colorGradient)
            }
        )
    }

}