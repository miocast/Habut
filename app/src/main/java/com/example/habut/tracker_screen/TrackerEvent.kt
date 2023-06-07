package com.example.habut.tracker_screen

import com.example.habut.data.TrackerItem

sealed class TrackerEvent{
    data class OnCheckedChange(val item: TrackerItem): TrackerEvent()
    object OnItemSave: TrackerEvent()
}
