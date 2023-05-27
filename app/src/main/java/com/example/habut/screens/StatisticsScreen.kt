package com.example.habut.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.habut.ScreenNavigate
import com.example.habut.ui.theme.Routes
import com.example.habut.ui.theme.Violet200
import com.example.habut.ui_components.BottomItem
import com.example.habut.ui_components.NavGraph

@Composable
fun StatisticsScreen(){
    val navController = rememberNavController()
    ScreenNavigate(navHostController = navController)

    Column() {
        Box() {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Routes.TRACKER_EDIT.route)
                    {
                        popUpTo(BottomItem.StatisticsScreen.route) {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier.padding(top = 10.dp),
                backgroundColor = Violet200,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 12.dp
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Кнопка добавить",
                    tint = Color.White
                )
            }
        }

        Text(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            text = "Страница статистики",
            textAlign = TextAlign.Center
        )
    }}








