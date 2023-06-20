package com.miocast.habut.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tracker_item")
data class TrackerItem(
    @PrimaryKey
    val id: Int? = null,
    val isDone: Boolean,
    val listId: Int
)
