package com.example.habut.main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.habut.dialog.MainDialog
import com.example.habut.navigation.NavigationGraph
import com.example.habut.ui.theme.Violet200


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    mainNavHostController: NavHostController,
    viewModel: MainScreenViewModel = hiltViewModel()

){
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        BottomNav(navController)
    },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                          viewModel.onEvent(MainScreenEvent.OnShowEditDialog)
                },
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
        NavigationGraph(navController){ route ->
            mainNavHostController.navigate(route)
        }
        MainDialog(viewModel)
    }
}
















