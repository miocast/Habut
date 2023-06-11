package com.miocast.habut.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tracker_list_name")
data class TrackerListItem(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val date: String,
    val isCheck: Boolean
)
