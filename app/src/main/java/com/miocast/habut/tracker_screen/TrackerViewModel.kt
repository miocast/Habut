package com.miocast.habut.tracker_screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miocast.habut.data.TrackerItem
import com.miocast.habut.data.TrackerItemRepository
import com.miocast.habut.data.TrackerListItem
import com.miocast.habut.tracker_list_screen.TrackerListEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackerViewModel @Inject constructor(
    private val repository: TrackerItemRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var itemsList: Flow<List<TrackerItem>>? = null
    var trackerItem: TrackerItem? = null
    var trackerListItem: TrackerListItem? = null
    var listId: Int = -1

//    var itemText = mutableStateOf("")
//        private set


    init {
        listId = savedStateHandle.get<String>("listId")?.toInt()!!
        itemsList = repository.getAllItemsById(listId)
        viewModelScope.launch {
            //а надо ли??
            trackerListItem = repository.getListItemById(listId)
        }
    }

    var checkedItem = mutableStateOf(false)

    fun onEvent(
        event: TrackerEvent){

        when(event){
            is TrackerEvent.OnItemSave -> {
                viewModelScope.launch {
                    if(listId == -1) return@launch
                    repository.insertItem(
                        TrackerItem(
                            trackerItem?.id,
                            trackerItem?.isDone ?: false,
                            listId
                        )
                    )
                    //
                    trackerItem = null
                }
            }
            is TrackerEvent.OnDelete -> {
                viewModelScope.launch {
                    repository.deleteItem(event.item)
                }
            }

            is TrackerEvent.OnCheckedChange -> {
                viewModelScope.launch {
                    repository.insertItem(event.item)
                }
            }
        }



    }
}

