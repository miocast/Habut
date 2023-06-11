package com.miocast.habut.di

import android.app.Application
import androidx.room.Room
import com.miocast.habut.data.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMainDb(app: Application): MainDb {
        return Room.databaseBuilder(
            app,
            MainDb::class.java,
            "tracker_list_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTrackerRepo(db: MainDb): TrackerListRepository{
        return TrackerListRepoImpl(db.trackerListDao)
    }

    @Provides
    @Singleton
    fun provideTrackerItemRepo(db: MainDb): TrackerItemRepository{
        return TrackerItemRepoImpl(db.trackerItemDao)
    }

    @Provides
    @Singleton
    fun provideNoteRepo(db: MainDb): NoteItemRepository{
        return NoteItemRepoImpl(db.noteItemDao)
    }

}