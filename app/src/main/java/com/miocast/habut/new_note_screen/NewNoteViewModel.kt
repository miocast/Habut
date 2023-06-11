package com.miocast.habut.new_note_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miocast.habut.data.NoteItem
import com.miocast.habut.data.NoteItemRepository
import com.miocast.habut.utils.UiEvent
import com.miocast.habut.utils.getCurrentTime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewNoteViewModel @Inject constructor(
    private val repository: NoteItemRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    private var noteId = -1
    private var noteItem: NoteItem? = null

    var title by mutableStateOf("")
        private set
    var description by mutableStateOf("")
        private set


    init {
        noteId = savedStateHandle.get<String>("noteId")?.toInt() ?: -1
        if (noteId != -1){
            viewModelScope.launch {
                repository.getNoteItemById(noteId).let { noteItem ->  
                    title = noteItem.title
                    description = noteItem.description
                    this@NewNoteViewModel.noteItem = noteItem
                }
            }
        }
    }

    fun onEvent(event: NewNoteEvent){
        when(event){
            is NewNoteEvent.OnSave -> {
                viewModelScope.launch {
                    if (title.isEmpty()){
                        sendUiEvent(UiEvent.ShowSnackBar(
                            "Title can not be empty!"
                        ))
                        return@launch
                    }
                    repository.insertItem(
                        NoteItem(
                            noteItem?.id,
                            title,
                            description,
                            noteItem?.time ?: getCurrentTime()
                        )
                    )
                    sendUiEvent(UiEvent.PopBackStack)
                }
            }
            is NewNoteEvent.OnTitleChange -> {
                title = event.title
            }
            is NewNoteEvent.OnDescriptionChange -> {
                description = event.description
            }
        }
    }


    private  fun sendUiEvent(event: UiEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}