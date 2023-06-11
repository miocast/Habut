package com.miocast.habut.main_screen

import com.miocast.habut.R
import com.miocast.habut.utils.Routes

sealed class BottomNavItem(val title: String, val iconId: Int, val route: String){
    object ListItem: BottomNavItem("Трекеры", R.drawable.icon_home, Routes.TRACKER_LIST)
    object NoteItem: BottomNavItem("Заметки", R.drawable.icon_note, Routes.NOTE_LIST)
    object SettingItem: BottomNavItem("Настройки", R.drawable.icon_settings, Routes.SETTINGS)

}