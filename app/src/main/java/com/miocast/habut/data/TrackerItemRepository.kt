package com.miocast.habut.data


import kotlinx.coroutines.flow.Flow

interface TrackerItemRepository {
    suspend fun insertItem(item: TrackerItem)
    suspend fun deleteItem(item: TrackerItem)
    fun getAllItemsById(listId: Int): Flow<List<TrackerItem>>

    suspend fun getListItemById(listId: Int): TrackerListItem
    suspend fun insertItem(item: TrackerListItem)

}