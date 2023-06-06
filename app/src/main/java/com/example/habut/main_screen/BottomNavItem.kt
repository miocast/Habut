package com.example.habut.main_screen

import com.example.habut.R
import com.example.habut.utils.Routes

sealed class BottomNavItem(val title: String, val iconId: Int, val route: String){
    object ListItem: BottomNavItem("Трекеры", R.drawable.icon_home, Routes.TRACKER_LIST)
    object StatisticsItem: BottomNavItem("Статистика", R.drawable.icon_statistics, Routes.STATISTICS)
    object NoteItem: BottomNavItem("Заметки", R.drawable.icon_sleeptracker, Routes.NOTE_LIST)
    object SettingItem: BottomNavItem("Настройки", R.drawable.icon_settings, Routes.SETTINGS)

}