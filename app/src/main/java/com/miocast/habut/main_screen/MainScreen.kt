package com.miocast.habut.main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.miocast.habut.dialog.MainDialog
import com.miocast.habut.navigation.NavigationGraph
import com.miocast.habut.ui.theme.Violet200
import com.miocast.habut.utils.Routes
import com.miocast.habut.utils.UiEvent


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    mainNavHostController: NavHostController,
    viewModel: MainScreenViewModel = hiltViewModel()

){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect{ uiEvent ->
            when(uiEvent){
                is UiEvent.NavigateMain -> {
                    mainNavHostController.navigate(uiEvent.route)
                }
                is UiEvent.Navigate -> {
                    navController.navigate(uiEvent.route)
                }
                else -> {}
            }
        }
    }


    Scaffold(
        bottomBar = {
        BottomNav(currentRoute){ route->
            viewModel.onEvent(MainScreenEvent.Navigate(route))

        }
    },
        floatingActionButton = {
            if (viewModel.showFloatingButton.value) FloatingActionButton(
                onClick = {
                    viewModel.onEvent(MainScreenEvent.OnNewItemClick(currentRoute ?: Routes.TRACKER_LIST))
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
            viewModel.onEvent(MainScreenEvent.NavigateMain(route))

        }
        MainDialog(viewModel)
    }
}
















