package com.miocast.habut.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.miocast.habut.main_screen.MainScreen
import com.miocast.habut.new_note_screen.NewNoteScreen
import com.miocast.habut.note_list_screen.NoteListScreen
import com.miocast.habut.settings_screen.SettingsScreen
import com.miocast.habut.tracker_list_screen.TrackerListScreen
import com.miocast.habut.tracker_screen.TrackerScreen
import com.miocast.habut.utils.Routes

@Composable
fun MainNavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MAIN_SCREEN){
        composable (Routes.TRACKER_ITEM + "/{listId}" ,
        ) {
            TrackerScreen()
        }

        composable (Routes.NEW_NOTE + "/{noteId}") {
            NewNoteScreen(){
                navController.popBackStack()
            }
        }

        composable (Routes.MAIN_SCREEN) {
            MainScreen(navController)
        }


    }
}