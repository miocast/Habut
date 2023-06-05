package com.example.habut.ui_components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.habut.main_screen.MainScreen
import com.example.habut.screens.*


//@Composable
//fun NavGraph(navController: NavHostController){
//    NavHost(navController = navController, startDestination = "screen_1"){
//        //bottom bar
//        composable("screen_1"){
//            MainScreen()
//        }
//
//        composable("screen_2"){
//            StatisticsScreen()
//        }
//
//        composable("screen_3"){
//            SleepTrackerScreen()
//        }
//
////        val trackerTitle = remember { mutableStateOf("") }
//
//        composable("tracker_screen"){
//            TrackerScreen(title = "")
//        }
//
//        composable("settings_screen"){
//            SettingsScreen()
//        }
//
//    }
//}