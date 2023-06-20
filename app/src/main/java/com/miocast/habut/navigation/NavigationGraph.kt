package com.miocast.habut.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.miocast.habut.note_list_screen.NoteListScreen
import com.miocast.habut.settings_screen.SettingsScreen
import com.miocast.habut.tracker_list_screen.TrackerListScreen
import com.miocast.habut.utils.Routes

@Composable
fun NavigationGraph(navController: NavHostController, onNavigate: (String) -> Unit) {
    NavHost(navController = navController, startDestination = Routes.TRACKER_LIST){
        composable (Routes.TRACKER_LIST) {
            TrackerListScreen(){route ->
                onNavigate(route)
            }
        }

        composable (Routes.NOTE_LIST) {
            NoteListScreen() { route ->
                onNavigate(route)
            }
        }


        composable (Routes.SETTINGS) {
            SettingsScreen()
        }


    }
}