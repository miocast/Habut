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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.habut.R
import com.example.habut.data.TrackerItem
import com.example.habut.data.TrackerListItem
import com.example.habut.dialog.MainDialog
import com.example.habut.main_screen.MainScreenEvent
import com.example.habut.tracker_list_screen.CurrentDate
import com.example.habut.tracker_list_screen.TrackerListViewModel
import com.example.habut.tracker_list_screen.UiTrackerListItem
import com.example.habut.ui.theme.*

@Composable
fun TrackerScreen(
    viewModel: TrackerViewModel = hiltViewModel()
) {

    HabutTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val gradient = Brush.verticalGradient(
                0.0f to Violet100,
                1.0f to Cosmos100,
                startY = 0.0f,
                endY = 2800.0f
            )
            Box(modifier = Modifier.background(gradient))
        }
    }

    val months = listOf(
        "ЯНВ",
        "ФЕВ",
        "МАР",
        "АПР",
        "МАЙ",
        "ИЮН",
        "ИЮЛ",
        "АВГ",
        "СЕН",
        "ОКТ",
        "НОЯ",
        "ДЕК"
    )


    val itemsList = viewModel.itemsList?.collectAsState(initial = emptyList())

    Column() {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 30.dp, top = 8.dp)
            ) {
                CurrentDate()

                FloatingActionButton(
                    onClick = {
                        viewModel.onEvent(TrackerEvent.OnItemSave)
                    },
                    modifier = Modifier.padding(start = 190.dp, top = 20.dp),
                    backgroundColor = Violet200,
                    elevation = FloatingActionButtonDefaults.elevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 12.dp
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Кнопка добавить день",
                        tint = Color.White
                    )
                }
            }

        }



        Column(
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp, end = 30.dp)
                .width(370.dp)
//                .background(color = Color.Red)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 11.dp, start = 11.dp, end = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "пн",
                    Modifier
                        .padding(start = 0.dp),
                    style = TextStyle(fontSize = 20.sp),
                    fontFamily = comfortaa,
                    color = Color.White)
                Text(text = "вт",
                    Modifier
                        .padding(start = 0.dp),
                    style = TextStyle(fontSize = 20.sp),
                    fontFamily = comfortaa,
                    color = Color.White)
                Text(text = "ср",
                    Modifier
                        .padding(start = 0.dp),
                    style = TextStyle(fontSize = 20.sp),
                    fontFamily = comfortaa,
                    color = Color.White)
                Text(text = "чт",
                    Modifier
                        .padding(start = 0.dp),
                    style = TextStyle(fontSize = 20.sp),
                    fontFamily = comfortaa,
                    color = Color.White)
                Text(text = "пт",
                    Modifier
                        .padding(start = 0.dp),
                    style = TextStyle(fontSize = 20.sp),
                    fontFamily = comfortaa,
                    color = Color.White)
                Text(text = "сб",
                    Modifier
                        .padding(start = 0.dp),
                    style = TextStyle(fontSize = 20.sp),
                    fontFamily = comfortaa,
                    color = Color.White)
                Text(text = "вс",
                    Modifier
                        .padding(start = 0.dp),
                    style = TextStyle(fontSize = 20.sp),
                    fontFamily = comfortaa,
                    color = Color.White)
            }
            LazyVerticalGrid(
                modifier = Modifier
                    .padding(2.dp),
                columns = GridCells.Adaptive(minSize = 50.dp)
            ) {
                if (itemsList != null) {
                    items(itemsList.value) { item ->
                        UiTrackerItem(item = item, onEvent = { event ->
                            viewModel.onEvent(event)
                        })
                    }
                }
            }
        }

        if (itemsList?.value?.isEmpty() == true) {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(),
                text = "Пусто",
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )
        }


    }


}

