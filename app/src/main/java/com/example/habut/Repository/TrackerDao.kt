package com.example.habut.Repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TrackerDao {
    @Query("SELECT * FROM tracker")
    fun getTrackers(): LiveData<Tracker>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTracker(tracker: Tracker)

    @Query("DELETE FROM Tracker where id = :id")
    suspend fun deleteTrackerById(id: Int)
}