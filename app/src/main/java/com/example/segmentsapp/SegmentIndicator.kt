package com.example.segmentsapp

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SegmentIndicator(
    modifier: Modifier = Modifier,
    gradientColors: List<Color> = greenGradient,
    onSegmentClicked: (Int, Boolean) -> Unit = { _, _ -> }
) {
    Column(modifier = modifier) {

        Row {
            Spacer(modifier = Modifier.width(20.dp))

            Segment(
                modifier = Modifier
                    .width(140.dp)
                    .height(30.dp),
                gradientColors = gradientColors,
                initialNum = 3
            ) { num, isSelected ->
                onSegmentClicked(num, isSelected)
            }
        }

        Row {
            Column {
                Segment(
                    modifier = Modifier
                        .width(30.dp)
                        .height(95.dp),
                    gradientColors = gradientColors,
                    initialNum = 2
                ) { num, isSelected ->
                    onSegmentClicked(num, isSelected)
                }

                Segment(
                    modifier = Modifier
                        .width(30.dp)
                        .height(95.dp),
                    gradientColors = gradientColors,
                    initialNum = 1
                )
                { num, isSelected ->
                    onSegmentClicked(num, isSelected)
                }

            }

            Column {
                Spacer(modifier = Modifier.height(80.dp))

                Segment(
                    modifier = Modifier
                        .width(120.dp)
                        .height(30.dp),
                    gradientColors = gradientColors,
                    initialNum = 7
                ) { num, isSelected ->
                    onSegmentClicked(num, isSelected)
                }
            }

            Column {
                Segment(
                    modifier = Modifier
                        .width(30.dp)
                        .height(95.dp),
                    gradientColors = gradientColors,
                    initialNum = 4
                ) { num, isSelected ->
                    onSegmentClicked(num, isSelected)
                }

                Segment(
                    modifier = Modifier
                        .width(30.dp)
                        .height(95.dp),
                    gradientColors = gradientColors,
                    initialNum = 5
                ) { num, isSelected ->
                    onSegmentClicked(num, isSelected)
                }
            }
        }

        Row {
            Spacer(modifier = Modifier.width(20.dp))

            Segment(
                modifier = Modifier
                    .width(140.dp)
                    .height(30.dp),
                gradientColors = gradientColors,
                initialNum = 6
            ) { num, isSelected ->
                onSegmentClicked(num, isSelected)
            }
        }
    }

}