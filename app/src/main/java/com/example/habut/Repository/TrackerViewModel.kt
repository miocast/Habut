package com.example.habut.Repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TrackerViewModel(appObj: Application) : AndroidViewModel(appObj) {
    private val trackerRepository: TrackerRepository = TrackerRepository(appObj)
    fun readAllTracker(): LiveData<Tracker>{
        return trackerRepository.readAllTracker
    }

    fun insertTracker(tracker: Tracker){
        viewModelScope.launch {
            trackerRepository.insertTracker(tracker = tracker)
        }
    }

    fun deleteTrackerById(id: Int){
        viewModelScope.launch {
            trackerRepository.deleteTrackerById(id)
        }
    }
}