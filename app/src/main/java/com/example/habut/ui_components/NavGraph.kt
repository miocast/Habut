package com.example.habut.ui_components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.habut.screens.*
import com.example.habut.ui.theme.Routes

@Composable
fun NavGraph(navHostController: NavHostController){
    val navController = rememberNavController()
    NavHost(navController = navHostController, startDestination = BottomItem.MainScreen.route){
        //bottom bar
        composable(BottomItem.MainScreen.route){
            MainScreen()
        }

        composable("screen_2"){
            StatisticsScreen()
        }

        composable("screen_3"){
            SleepTrackerScreen()
        }



        composable(Routes.TRACKER_EDIT.route){
            TrackerEdit()
        }

        composable(Routes.SETTINGS_SCREEN.route){
            SettingsScreen()
        }

    }
}