package com.example.habut.Repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Tracker::class], version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase() {
    abstract fun trackerDao(): TrackerDao

    companion object {
        @Volatile
        private var INSTANCE: AppDB? = null

        fun getDB(context: Context): AppDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDB::class.java, "app_database"
                )
                    .createFromAsset("database/tracker.db")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}