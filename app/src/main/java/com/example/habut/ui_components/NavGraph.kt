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
            MainScreen()
        }

        composable("screen_2"){
            StatisticsScreen()
        }

        composable("screen_3"){
            SleepTrackerScreen()
        }




//        composable(Routes.TRACKER_EDIT.route){
//            TrackerEdit()
//        }
//
//        composable(Routes.SETTINGS_SCREEN.route){
//            SettingsScreen()
//        }

    }
}