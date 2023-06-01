package com.example.habut.ui_components

import com.example.habut.R

sealed class Routes (val route: String){
    object SettingsScreen: Routes("settings_screen")
    object TrackerScreen: Routes("tracker_screen")
}