package com.example.habut.screens


import android.icu.util.Calendar
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.habut.TrackerItems
import com.example.habut.getListItems
import com.example.habut.ui.theme.*
import com.example.habut.ui_components.Routes


@Composable
fun MainScreen(navController: NavController){

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

    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Row(modifier = Modifier
                .padding(start = 30.dp, top = 8.dp)
            ) {
                CurrentDate()
            }

            ButtonSettings(navController = navController)
        }

        Text(modifier = Modifier
            .padding(top = 16.dp)
            .height(85.dp),
            text = "Твои привычки",
            fontFamily = comfortaa,
            color = Color.White,
            fontSize = 30.sp)

        Box(modifier = Modifier.height(480.dp)) {
            TrackerItemsList(itemList = getListItems(), navController = navController)
        }

        ButtonAdd()

    }
}


@Composable
fun CurrentDate(){
    val calendar = Calendar.getInstance()

    val year = calendar[Calendar.YEAR]
    val month = calendar[Calendar.MONTH]
    val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]

    var stringMonth: String? = null

    when (month){
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

    Column(modifier = Modifier
        .padding(start = 4.dp, top = 21.dp)
    ){

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


@Composable
fun ButtonSettings(navController: NavController){
    IconButton(
        onClick = {
            navController.navigate(Routes.SettingsScreen.route)
        },

        modifier = Modifier
            .padding(top = 25.dp, start = 0.dp, end = 30.dp)
    ) {

        Icon(
            Icons.Filled.Settings,
            modifier = Modifier
                .size(50.dp),
            contentDescription = "Настройки",
            tint = Color.White
        )
    }
}


@Composable
fun TrackerItemsList(itemList: List<TrackerItems>, navController: NavController){
    val deletedItem = remember { mutableStateListOf<TrackerItems>() }

    Column{
        LazyColumn{
            itemsIndexed(items = itemList,
                itemContent = { _, item ->
                AnimatedVisibility(
                    visible = !deletedItem.contains(item),
//                    enter = expandVertically(),
//                    exit = shrinkVertically(animationSpec = tween(durationMillis = 200))
                )
                {
                    Card(
                        modifier = Modifier
                            .height(80.dp)
                            .padding(start = 22.dp, end = 22.dp, top = 10.dp, bottom = 4.dp)
                            .clickable {
                                navController.navigate(Routes.TrackerScreen.route)
                            }
                        ,
                        shape = RoundedCornerShape(100.dp),

                    ) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                                )
                            {


                                Box(
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .size(56.dp)
                                        .background(
                                            color = Violet200,
                                            shape = CircleShape
                                        )
                                        .clickable {}
                                ) {}

                                Text(

                                    text = item.name ,
                                    modifier = Modifier
                                        .width(230.dp)
                                        .fillMaxWidth()
                                        .padding(start = 20.dp),
                                    textAlign = TextAlign.Start,
                                    color = Violet100,

                                    fontFamily = comfortaa
                                )

                                Box{
                                    IconButton(
                                    onClick = {
                                        deletedItem.add(item)
                                    })

                                    {
                                        Icon(imageVector = Icons.Filled.Delete, contentDescription = "Удалить трекер")
                                    }
                                }
                            }
                        }
                    }
                }

                })
        }
    }
}


@Composable
fun ButtonAdd() {
    var visible by remember {
        mutableStateOf(false)
    }


    TrackerCreate(
        visible = visible,
        confirmButtonClicked = {
            visible = false
        },
        closeClicked = {
            visible = false
        }
    )

    FloatingActionButton(
        onClick = {
            visible = true
        },
        modifier = Modifier.padding(top = 15.dp)
        ,
        backgroundColor = Violet200,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 8.dp,
            pressedElevation = 12.dp
        )
    ) {
        Icon(imageVector = Icons.Default.Add,
            contentDescription = "Кнопка добавить",
            tint = Color.White)
    }
}














