package com.example.habut.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: NoteItem)

    @Delete
    suspend fun deleteItem(item: NoteItem)

    @Query("SELECT * FROM note_table")
    fun getAllItems(): Flow<List<NoteItem>>

    @Query("SELECT * FROM note_table WHERE id = :id")
    suspend fun getNoteItemById(id: Int): NoteItem
}