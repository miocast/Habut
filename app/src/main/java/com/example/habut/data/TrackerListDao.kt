package com.example.habut.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackerListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: TrackerListItem)
    @Delete
    suspend fun deleteItem(item: TrackerListItem)
    @Query("SELECT * FROM tracker_list_name")
    fun getAllItems(): Flow<List<TrackerListItem>>

}
