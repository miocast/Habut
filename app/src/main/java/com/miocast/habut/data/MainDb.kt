package com.miocast.habut.data

import androidx.room.*

@Database(
    entities = [
        TrackerListItem::class,
        TrackerItem::class,
        NoteItem::class],
    version = 1,
    exportSchema = true
)
abstract class MainDb : RoomDatabase() {
    abstract val trackerListDao: TrackerListDao
    abstract val noteItemDao: NoteItemDao
    abstract val trackerItemDao: TrackerItemDao
}