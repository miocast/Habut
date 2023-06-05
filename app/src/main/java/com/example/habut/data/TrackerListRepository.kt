package com.example.habut.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

interface TrackerListRepository {
    suspend fun insertItem(item: TrackerListItem)

    suspend fun deleteItem(item: TrackerListItem)

    fun getAllItems(): Flow<List<TrackerListItem>>


}