package com.example.habut.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.rememberNavController

@Composable
fun StatisticsScreen() {
    val navController = rememberNavController()


    Column {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            text = "Страница статистики",
            textAlign = TextAlign.Center
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









