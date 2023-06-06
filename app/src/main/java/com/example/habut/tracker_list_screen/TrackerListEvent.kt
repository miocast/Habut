package com.example.habut.tracker_list_screen

import com.example.habut.data.TrackerListItem

sealed class TrackerListEvent{
    data class OnShowDeleteDialog(val item: TrackerListItem): TrackerListEvent()
    data class OnShowEditDialog(val item: TrackerListItem): TrackerListEvent()
    data class OnItemClick(val route: String): TrackerListEvent()
    object OnItemSave: TrackerListEvent()
}
