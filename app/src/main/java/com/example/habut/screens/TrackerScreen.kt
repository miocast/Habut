package com.example.habut.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habut.ui.theme.Cosmos100
import com.example.habut.ui.theme.HabutTheme
import com.example.habut.ui.theme.Violet100
import com.example.habut.ui.theme.comfortaa

@Composable
fun TrackerкScreen(
    title: String
) {

    val trackerTitle = remember { mutableStateOf("ТРЕКЕР") }

    HabutTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val gradient = Brush.verticalGradient(
                0.0f to Violet100,
                1.0f to Cosmos100,
                startY = 0.0f,
                endY = 2800.0f
            )
            Box(modifier = Modifier.background(gradient))
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,) {
        Text(
            modifier = Modifier
                .padding(top = 50.dp)
                .height(85.dp),
            text = trackerTitle.value,
            fontFamily = comfortaa,
            color = Color.White,
            fontSize = 30.sp)

    }



}