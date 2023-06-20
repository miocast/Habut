package com.miocast.habut.tracker_screen

import com.miocast.habut.data.TrackerItem

sealed class TrackerEvent{
    data class OnDelete(val item: TrackerItem): TrackerEvent()
    data class OnCheckedChange(val item: TrackerItem): TrackerEvent()
    object OnItemSave: TrackerEvent()
}
