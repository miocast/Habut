package com.example.habut.main_screen

import com.example.habut.data.TrackerListItem
import com.example.habut.tracker_list_screen.TrackerListEvent

sealed class MainScreenEvent {
    object OnShowEditDialog: MainScreenEvent()
    object OnItemSave: MainScreenEvent()
}