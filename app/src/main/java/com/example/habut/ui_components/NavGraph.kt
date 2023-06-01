package com.example.habut.ui_components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.habut.screens.*


@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "screen_1"){
        //bottom bar
        composable("screen_1"){
            MainScreen(navController = navController)
        }

        composable("screen_2"){
            StatisticsScreen()
        }

        composable("screen_3"){
            SleepTrackerScreen()
        }

        composable("screen_4"){
            TrackerScreen()
        }

        composable("settings_screen"){
            SettingsScreen()
        }

        composable("tracker_screen"){
            TrackerScreen()
        }




    }
}