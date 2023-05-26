package com.example.habut.ui.theme

import com.example.habut.R
import com.example.habut.ui_components.BottomItem

sealed class Routes(val route: String) {
    object MAIN_SCREEN: Routes("Main_Screen")
    object TRACKER_SCREEN : Routes("TrackerScreen")
    object TRACKER_EDIT : Routes("Tracker_Edit")
    object SETTINGS_SCREEN : Routes("SettingsScreen")
}