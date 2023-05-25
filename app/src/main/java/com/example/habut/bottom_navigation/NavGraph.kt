package com.example.habut.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.habut.screens.*

@Composable
fun NavGraph(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = "screen_1"){
        //bottom bar
        composable("screen_2"){
            StatisticsScreen()
        }
        composable("screen_1"){
            MainScreen()
        }
        composable("screen_3"){
            SleepTrackerScreen()
        }

        //остальные экраны
        composable("TrackerScreen"){
            TrackerScreen()
        }

        composable("TrackerEdit"){
            TrackerEdit()
        }

    }
}