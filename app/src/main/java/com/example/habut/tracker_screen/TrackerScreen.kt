package com.example.habut.tracker_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.habut.R
import com.example.habut.data.TrackerItem
import com.example.habut.data.TrackerListItem
import com.example.habut.tracker_list_screen.TrackerListViewModel
import com.example.habut.tracker_list_screen.UiTrackerListItem
import com.example.habut.ui.theme.Cosmos100
import com.example.habut.ui.theme.Gray100
import com.example.habut.ui.theme.Violet100
import com.example.habut.ui.theme.Violet200

@Composable
fun TrackerScreen(
    viewModel: TrackerViewModel = hiltViewModel()
) {
    val itemsList = viewModel.itemsList?.collectAsState(initial = emptyList())

    Column() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ){
            Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically){
                TextField(
                    modifier = Modifier.weight(1f),
                    value = viewModel.itemText.value,
                    onValueChange = { text ->
                        viewModel.onEvent(TrackerEvent.OnTextChange(text))
                    },
                    label = {
                        Text(
                            text = "New item",
                            fontSize = 12.sp
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        focusedIndicatorColor = Violet100,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    singleLine = true
                )

                IconButton(
                    onClick = {
                        viewModel.onEvent(TrackerEvent.OnItemSave)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add"
                    )
                }

            }
        }

//        UiTrackerItem(item = itemsList.value, onEvent = {event ->
//            viewModel.onEvent(event)
//        })

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 60.dp)
        ){
            if (itemsList != null){
                items(itemsList.value){item ->
                    UiTrackerItem(item = item, onEvent = {event ->
                        viewModel.onEvent(event)
                    })
                }
            }
        }

//        LazyColumn(modifier = Modifier
//            .fillMaxSize()
//            .padding(top = 10.dp)
//        ){
//            if (itemsList != null){
//                items(itemsList.value){item ->
//                    UiTrackerItem(item = item, onEvent = {event ->
//                        viewModel.onEvent(event)
//                    })
//                }
//            }
//        }

    }

}





//@Composable
//fun TrackerScreen(
//    viewModel: TrackerViewModel = hiltViewModel()
//) {
//    val itemsList = viewModel.itemsList?.collectAsState(initial = emptyList())
//
//    Column() {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(5.dp)
//        ){
//            Row(modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically){
//                TextField(
//                    modifier = Modifier.weight(1f),
//                    value = viewModel.itemText.value,
//                    onValueChange = { text ->
//                        viewModel.onEvent(TrackerEvent.OnTextChange(text))
//                    },
//                    label = {
//                        Text(
//                            text = "New item",
//                            fontSize = 12.sp
//                        )
//                    },
//                    colors = TextFieldDefaults.textFieldColors(
//                        backgroundColor = Color.White,
//                        focusedIndicatorColor = Violet100,
//                        unfocusedIndicatorColor = Color.Transparent
//                    ),
//                    textStyle = TextStyle(
//                        fontSize = 16.sp,
//                        color = Color.Black
//                    ),
//                    singleLine = true
//                )
//
//                IconButton(
//                    onClick = {
//                        viewModel.onEvent(TrackerEvent.OnItemSave)
//                    }
//                ) {
//                    Icon(
//                        imageVector = Icons.Filled.Add,
//                        contentDescription = "Add"
//                    )
//                }
//
//            }
//        }
//
//        LazyColumn(modifier = Modifier
//            .fillMaxSize()
//            .padding(top = 10.dp)
//        ){
//            if (itemsList != null){
//                items(itemsList.value){item ->
//                    UiTrackerItem(item = item, onEvent = {event ->
//                        viewModel.onEvent(event)
//                    })
//                }
//            }
//        }
//
//    }
//}