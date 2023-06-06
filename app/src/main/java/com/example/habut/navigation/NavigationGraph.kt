package com.example.habut.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.habut.note_list_screen.NoteListScreen
import com.example.habut.screens.StatisticsScreen
import com.example.habut.settings_screen.SettingsScreen
import com.example.habut.tracker_list_screen.TrackerListScreen
import com.example.habut.utils.Routes

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.TRACKER_LIST){
        composable (Routes.TRACKER_LIST) {
            TrackerListScreen()
        }

        composable (Routes.NOTE_LIST) {
            NoteListScreen()
        }

        composable (Routes.STATISTICS) {
            StatisticsScreen()
        }

        composable (Routes.SETTINGS) {
            SettingsScreen()
        }


    }
}