package com.example.habut.tracker_list_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habut.data.TrackerListItem
import com.example.habut.data.TrackerListRepository
import com.example.habut.dialog.DialogEvent
import com.example.habut.dialog.DialogController
import com.example.habut.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackerListViewModel @Inject constructor(
    private val repository: TrackerListRepository
): ViewModel(), DialogController {

    val list = repository.getAllItems()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var listItem: TrackerListItem? = null

    override var dialogTitle = mutableStateOf("")
        private set
    override var editableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditableText = mutableStateOf(false)
        private set

    fun onEvent(event: TrackerListEvent){
        when(event){
            is TrackerListEvent.OnItemSave -> {
                if (editableText.value.isEmpty()) return
                viewModelScope.launch {
                    repository.insertItem(
                        TrackerListItem(
                            listItem?.id,
                            editableText.value,
                            "12:30",
                            listItem?.isCheck ?: false
                        )
                    )
                }
            }
            is TrackerListEvent.OnCheckedChange -> {
                viewModelScope.launch{
                    repository.insertItem(event.item)
                }
            }
            is TrackerListEvent.OnItemClick -> {
                sendUiEvent(UiEvent.Navigate(event.route))
            }
            is TrackerListEvent.OnShowEditDialog -> {
                listItem = event.item
                openDialog.value = true
                editableText.value = listItem?.name ?: ""
                dialogTitle.value = "Название трекера:"
                showEditableText.value = true
            }
            is TrackerListEvent.OnShowDeleteDialog -> {
                listItem = event.item
                openDialog.value = true
                dialogTitle.value = "Удалить трекер?"
                showEditableText.value = false
            }
        }
    }

    override fun onDialogEvent(event: DialogEvent){
        when(event){
            is DialogEvent.OnCancel -> {
                openDialog.value = false
            }
            is DialogEvent.OnConfirm -> {
                if(showEditableText.value){
                    onEvent(TrackerListEvent.OnItemSave)
                } else {
                    viewModelScope.launch {
                        listItem?.let { repository.deleteItem(it) }
                    }
                }

                openDialog.value = false
            }
            is DialogEvent.OnTextChange -> {
                editableText.value = event.text
            }
        }
    }

    private  fun sendUiEvent(event: UiEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}