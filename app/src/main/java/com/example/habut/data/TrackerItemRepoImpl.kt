package com.example.habut.data

import kotlinx.coroutines.flow.Flow

class TrackerItemRepoImpl (
    private val dao: TrackerItemDao
    ) : TrackerItemRepository {
    override suspend fun insertItem(item: TrackerItem) {
        dao.insertItem(item)
    }
    override suspend fun deleteItem(item: TrackerItem) {
        dao.deleteItem(item)
    }
    override fun getAllItemsById(listId: Int): Flow<List<TrackerItem>> {
        return dao.getAllItemsById(listId)
    }


}

