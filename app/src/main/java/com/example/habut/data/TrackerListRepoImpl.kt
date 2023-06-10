package com.example.habut.data

import kotlinx.coroutines.flow.Flow

class TrackerListRepoImpl (
    private val dao: TrackerListDao
    ) : TrackerListRepository {

    override suspend fun insertItem(item: TrackerListItem) {
        dao.insertItem(item)
    }

    override suspend fun deleteItem(item: TrackerListItem) {
        dao.deleteTrackerList(item)
    }

    override fun getAllItems(): Flow<List<TrackerListItem>> {
        return dao.getAllItems()
    }



}