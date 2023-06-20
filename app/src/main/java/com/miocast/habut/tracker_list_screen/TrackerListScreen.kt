package com.miocast.habut.tracker_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.miocast.habut.dialog.MainDialog
import com.miocast.habut.ui.theme.Cosmos100
import com.miocast.habut.ui.theme.HabutTheme
import com.miocast.habut.ui.theme.Violet100
import com.miocast.habut.ui.theme.comfortaa
import com.miocast.habut.utils.UiEvent
import java.util.*

@Composable
fun TrackerListScreen(
    viewModel: TrackerListViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit
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

    val itemsList = viewModel.list.collectAsState(initial = emptyList())
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect{uiEvent ->
            when(uiEvent){
                is UiEvent.Navigate -> {
                    onNavigate(uiEvent.route)
                }
                else -> {}
            }

        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 30.dp, top = 8.dp)
            ) {
                CurrentDate()
            }

        }

        Text(
            modifier = Modifier
                .padding(
                    top = 16.dp
                )
                .height(85.dp),
            text = "Твои привычки",
            fontFamily = comfortaa,
            color = Color.White,
            fontSize = 30.sp
        )


        Box(
            modifier = Modifier
                .height(480.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(itemsList.value) { item ->
                    UiTrackerListItem(item) { event ->
                        viewModel.onEvent(event)
                    }
                }
            }

            MainDialog(viewModel)
        }
    }

    if (itemsList.value.isEmpty()) {
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

@Composable
fun CurrentDate() {
    val calendar = Calendar.getInstance()

    val year = calendar[Calendar.YEAR]
    val month = calendar[Calendar.MONTH]
    val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]

    var stringMonth: String? = null

    when (month) {
        0 -> stringMonth = "Января"
        1 -> stringMonth = "Февраля"
        2 -> stringMonth = "Марта"
        3 -> stringMonth = "Апреля"
        4 -> stringMonth = "Мая"
        5 -> stringMonth = "Июня"
        6 -> stringMonth = "Июля"
        7 -> stringMonth = "Августа"
        8 -> stringMonth = "Сентября"
        9 -> stringMonth = "Октября"
        10 -> stringMonth = "Ноября"
        11 -> stringMonth = "Декабря"
    }

    Text(
        text = "$dayOfMonth",
        style = TextStyle(fontSize = 50.sp),
        fontFamily = comfortaa,
        color = Color.White
    )

    Column(
        modifier = Modifier
            .padding(start = 4.dp, top = 21.dp)
    ) {

        Text(
            text = "$year",
            style = TextStyle(fontSize = 15.sp),
            fontFamily = comfortaa,
            color = Color.White
        )

        Text(
            text = "$stringMonth",
            style = TextStyle(fontSize = 15.sp),
            fontFamily = comfortaa,
            color = Color.White
        )
    }
}