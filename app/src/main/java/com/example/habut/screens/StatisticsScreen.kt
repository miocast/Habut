package com.example.habut.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.habut.ui.theme.Cosmos100
import com.example.habut.ui.theme.HabutTheme
import com.example.habut.ui.theme.Violet100
import com.example.habut.ui.theme.comfortaa

@Composable
fun StatisticsScreen() {
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
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 80.dp, top = 50.dp)
                .height(85.dp),
            text = "Статистика",
            fontFamily = comfortaa,
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


//        Box() {
//            FloatingActionButton(
//                onClick = {
//                    navController.navigate(Routes.TRACKER_EDIT.route)
//                    {
//                        popUpTo(BottomItem.StatisticsScreen.route) {
//                            inclusive = true
//                        }
//                    }
//                },
//                modifier = Modifier.padding(top = 10.dp),
//                backgroundColor = Violet200,
//                elevation = FloatingActionButtonDefaults.elevation(
//                    defaultElevation = 8.dp,
//                    pressedElevation = 12.dp
//                )
//            ) {
//
//                Icon(
//                    imageVector = Icons.Default.Add,
//                    contentDescription = "Кнопка добавить",
//                    tint = Color.White
//                )
//
//            }
//        }









