package com.example.habut.ui_components

import androidx.compose.material.icons.filled.Settings
import com.example.habut.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String){
    object MainScreen: BottomItem("Главная страница", R.drawable.icon_home, "screen_1")
    object StatisticsScreen: BottomItem("Статистика", R.drawable.icon_statistics, "screen_2")
    object SleepTrackerScreen: BottomItem("Трекер сна", R.drawable.icon_sleeptracker, "screen_3")

}


