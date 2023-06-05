package com.example.habut.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tracker_item")
data class TrackerItem(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val day: String,
    val isDone: Boolean,
    val listId: Int
)
