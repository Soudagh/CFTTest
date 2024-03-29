package com.example.cfttest.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun InfoRow(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black
) {
    Text(modifier = modifier, text = "${title}: $description", fontSize = 20.sp, color = textColor)
}

@Preview
@Composable
fun InfoRowPreview() {
    InfoRow(title = "Name", description = "Ivan Ivanov")
}