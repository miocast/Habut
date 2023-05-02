package com.example.habut.bottom_navigation

import com.example.habut.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String){
    object MainScreen: BottomItem("Главная страница", R.drawable.icon_star, "screen_1")
    object StatisticsScreen: BottomItem("Статистика", R.drawable.icon_star, "screen_2")
    object SleepTrackerScreen: BottomItem("Трекер сна", R.drawable.icon_star, "screen_3")
}
