package com.example.habut.ui.theme

import com.example.habut.R
import com.example.habut.ui_components.BottomItem

sealed class Routes(val route: String) {
    object MainScreen: Routes("Main_Screen")
    object TRACKER_EDIT : Routes("Tracker_Edit")
    object SETTINGS_SCREEN : Routes("SettingsScreen")
}