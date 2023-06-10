package com.example.habut.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackerListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: TrackerListItem)
    @Delete
    suspend fun deleteItem(item: TrackerListItem)
    @Query("DELETE FROM tracker_item WHERE listId = :listId")
    suspend fun deleteTrackerItem(listId: Int)
    @Query("SELECT * FROM tracker_list_name")
    fun getAllItems(): Flow<List<TrackerListItem>>

    @Transaction
    suspend fun deleteTrackerList(item: TrackerListItem){
        deleteTrackerItem(item.id!!)
        deleteItem(item)
    }

}
