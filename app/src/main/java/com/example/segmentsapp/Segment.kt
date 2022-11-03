package com.example.segmentsapp

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun Segment(
    modifier: Modifier = Modifier,
    initialNum: Int = 0,
    gradientColors: List<Color> = listOf(),
    onClicked: (Int, Boolean) -> Unit = { _, _ -> },
) {

    var isSelected by remember {
        mutableStateOf(false)
    }

    var tapOffset by remember {
        mutableStateOf(Offset.Zero)
    }

    var canvasCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    var canvasSize by remember {
        mutableStateOf(Size.Zero)
    }

    val circleRadius = animateFloatAsState(
        targetValue = if (isSelected) (maxOf(canvasSize.width, canvasSize.height)) else 1f,
        animationSpec = tween(400),
    )

    val segmentPath = Path().apply {
        addRoundRect(
            RoundRect(
                top = canvasCenter.y - canvasSize.height / 2,
                left = canvasCenter.x - canvasSize.width / 2,
                right = canvasCenter.x + canvasSize.width / 2,
                bottom = canvasCenter.y + canvasSize.height / 2,
                cornerRadius = CornerRadius(
                    x = 20f,
                    y = 20f
                )
            )
        )
    }

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray, shape = RoundedCornerShape(5.dp))
            .border(
                width = 5.dp,
                shape = RoundedCornerShape(5.dp),
                color = Color.Black
            )
            .pointerInput(canvasCenter) {
                detectTapGestures {
                    if (segmentPath
                            .getBounds()
                            .contains(it)
                    ) {
                        tapOffset = it
                        isSelected = !isSelected

                        onClicked(initialNum, isSelected)
                    }
                }
            }
    ) {
        canvasCenter = center
        canvasSize = size


        drawPath(
            color = Color.Black,
            path = segmentPath,
            style = Stroke(
                0.dp.toPx(),
                cap = StrokeCap.Round
            )
        )

        clipPath(segmentPath) {
            drawCircle(
                brush = Brush.radialGradient(
                    colors = gradientColors,
                    center = tapOffset,
                    radius = circleRadius.value
                ),
                center = tapOffset,
                radius = circleRadius.value
            )
        }
    }
}