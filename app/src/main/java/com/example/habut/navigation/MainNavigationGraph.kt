package com.example.habut.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.habut.main_screen.MainScreen
import com.example.habut.new_note_screen.NewNoteScreen
import com.example.habut.note_list_screen.NoteListScreen
import com.example.habut.screens.StatisticsScreen
import com.example.habut.settings_screen.SettingsScreen
import com.example.habut.tracker_list_screen.TrackerListScreen
import com.example.habut.tracker_screen.TrackerScreen
import com.example.habut.utils.Routes

@Composable
fun MainNavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MAIN_SCREEN){
        composable (Routes.TRACKER_ITEM + "/{listId}" + "/{listName}",
            arguments = listOf(
                navArgument("listName"){

                }
            )
        ) {
            TrackerScreen()
        }

        composable (Routes.NEW_NOTE ) {
            NewNoteScreen()
        }

        composable (Routes.MAIN_SCREEN) {
            MainScreen(navController)
        }


    }
}