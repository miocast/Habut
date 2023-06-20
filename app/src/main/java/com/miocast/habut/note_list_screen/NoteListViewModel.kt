package com.miocast.habut.note_list_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miocast.habut.data.NoteItem
import com.miocast.habut.data.NoteItemRepository
import com.miocast.habut.dialog.DialogController
import com.miocast.habut.dialog.DialogEvent
import com.miocast.habut.new_note_screen.NewNoteEvent
import com.miocast.habut.tracker_list_screen.TrackerListEvent
import com.miocast.habut.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val repository: NoteItemRepository
)
    : ViewModel(), DialogController{

    val noteListFlow = repository.getAllItems()
    private var noteItem: NoteItem? = null

    val noteList = repository.getAllItems()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    override var dialogTitle = mutableStateOf("Удалить заметку?")
        private set
    override var editableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditableText = mutableStateOf(false)
        private set

    fun onEvent(event: NoteListEvent){
        when(event){
//            is NoteListEvent.OnTextSearchChange -> {
//                searchText = event.text
//                noteList = originNoteList.filter { note ->
//                    note.title.lowercase().startsWith(searchText.lowercase())
//                }
//            }
            is NoteListEvent.OnShowDeleteDialog -> {
                openDialog.value = true
                noteItem = event.item
            }
            is NoteListEvent.OnItemClick -> {
                sendUiEvent(UiEvent.Navigate(event.route))
            }
            is NoteListEvent.UnDoneDeleteItem -> {
                viewModelScope.launch {
                    repository.insertItem(noteItem!!)
                }
            }
        }
    }

    override fun onDialogEvent(event: DialogEvent){
        when(event){
            is DialogEvent.OnCancel -> {
                openDialog.value = false
            }
            is DialogEvent.OnConfirm -> {
                viewModelScope.launch {
                    repository.deleteItem(noteItem!!)
                    sendUiEvent(UiEvent.ShowSnackBar("Undone delete item?"))
                }
                openDialog.value = false
            }
            else -> {}
        }
    }


    private  fun sendUiEvent(event: UiEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}