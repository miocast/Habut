package com.example.habut.main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.habut.ui.theme.Cosmos100
import com.example.habut.ui.theme.HabutTheme
import com.example.habut.ui.theme.Violet100
import com.example.habut.ui.theme.Violet200


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(){
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

    Scaffold(bottomBar = {
        BottomNav()
    },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {  },
                modifier = Modifier.padding(bottom = 20.dp),
                backgroundColor = Violet200,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 12.dp
                )
            ) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "Кнопка добавить",
                    tint = Color.White)
            }
        },

        floatingActionButtonPosition = FabPosition.Center

    ) {

    }
}
















