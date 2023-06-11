package com.miocast.habut.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackerItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: TrackerItem)
    @Delete
    suspend fun deleteItem(item: TrackerItem)
    @Query("SELECT * FROM tracker_item WHERE listId = :listId")
    fun getAllItemsById(listId: Int): Flow<List<TrackerItem>>
    @Query("SELECT * FROM tracker_list_name WHERE id = :listId")
    suspend fun getListItemsById(listId: Int): TrackerListItem
    @Update
    suspend fun insertItem(item: TrackerListItem)
}