package com.miocast.habut.data

import kotlinx.coroutines.flow.Flow

class TrackerItemRepoImpl (
    private val dao: TrackerItemDao
    ) : TrackerItemRepository {
    override suspend fun insertItem(item: TrackerItem) {
        dao.insertItem(item)
    }

    override suspend fun insertItem(item: TrackerListItem) {
        dao.insertItem(item)
    }

    override suspend fun deleteItem(item: TrackerItem) {
        dao.deleteItem(item)
    }
    override fun getAllItemsById(listId: Int): Flow<List<TrackerItem>> {
        return dao.getAllItemsById(listId)
    }

    override suspend fun getListItemById(listId: Int): TrackerListItem {
        return dao.getListItemsById(listId)
    }


}

