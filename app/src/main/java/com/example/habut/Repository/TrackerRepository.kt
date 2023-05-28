package com.example.habut.Repository

import android.app.Application
import androidx.lifecycle.LiveData

class TrackerRepository (application: Application){
    private var trackerDao: TrackerDao

    init {
        val database = AppDB.getDB(application)
        trackerDao = database.trackerDao()
    }

    val readAllTracker: LiveData<Tracker> = trackerDao.getTrackers()

    suspend fun insertTracker(tracker: Tracker){
        trackerDao.insertTracker(tracker)
    }

    suspend fun deleteTrackerById(id: Int){
        trackerDao.deleteTrackerById(id)
    }

    init {
        val database = AppDB.getDB(application)
        trackerDao = database.trackerDao()
    }
}