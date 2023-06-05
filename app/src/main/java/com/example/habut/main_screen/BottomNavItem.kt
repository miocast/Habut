package com.example.habut.main_screen

import com.example.habut.R
import com.example.habut.ui_components.BottomItem

sealed class BottomNavItem(val title: String, val iconId: Int, val route: String){
    object MainScreen: BottomNavItem("Главная страница", R.drawable.icon_home, "screen_1")
    object StatisticsScreen: BottomNavItem("Статистика", R.drawable.icon_statistics, "screen_2")
    object SleepTrackerScreen: BottomNavItem("Настройки", R.drawable.icon_sleeptracker, "screen_3")

}