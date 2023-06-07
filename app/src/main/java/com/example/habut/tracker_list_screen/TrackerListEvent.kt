package com.example.habut.tracker_list_screen

import com.example.habut.data.TrackerItem
import com.example.habut.data.TrackerListItem
import com.example.habut.tracker_screen.TrackerEvent

sealed class TrackerListEvent{
    data class OnShowDeleteDialog(val item: TrackerListItem): TrackerListEvent()
    data class OnShowEditDialog(val item: TrackerListItem): TrackerListEvent()
    data class OnItemClick(val route: String): TrackerListEvent()
    data class OnCheckedChange(val item: TrackerListItem): TrackerListEvent()
    object OnItemSave: TrackerListEvent()
}
