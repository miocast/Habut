package com.example.habut

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.habut.screens.*
import com.example.habut.ui.theme.Routes
import com.example.habut.ui.theme.Violet200
import com.example.habut.ui_components.BottomItem

@Composable
fun ScreenNavigate(navHostController: NavHostController){
    val navController = rememberNavController()
    NavHost(navController = navHostController, startDestination = BottomItem.StatisticsScreen.route){

        composable(BottomItem.StatisticsScreen.route){
            StatisticsScreen()
        }

        composable(Routes.TRACKER_EDIT.route){
            TrackerEdit()
        }

        composable(Routes.TRACKER_EDIT.route){
            SettingsScreen()
        }

        composable(Routes.SETTINGS_SCREEN.route){
            SettingsScreen()
        }
    }

}
