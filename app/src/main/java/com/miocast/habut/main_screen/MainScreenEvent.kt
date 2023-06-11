package com.miocast.habut.main_screen

import com.miocast.habut.data.TrackerListItem
import com.miocast.habut.tracker_list_screen.TrackerListEvent

sealed class MainScreenEvent {
    object OnItemSave: MainScreenEvent()
    data class Navigate(val route: String): MainScreenEvent()
    data class NavigateMain(val route: String): MainScreenEvent()
    data class OnNewItemClick(val route: String): MainScreenEvent()
}