package com.example.habut.screens

import android.annotation.SuppressLint
import android.icu.util.Calendar
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
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.rememberNavController
import com.example.habut.ScreenNavigate
import com.example.habut.TrackerItems
import com.example.habut.getListItems
import com.example.habut.ui.theme.*
import com.example.habut.ui_components.BottomItem
import com.example.habut.ui_components.BottomNavigationBar
import com.example.habut.ui_components.NavGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(){



}


//@Composable
//fun MainScreen(){
//    val navController = rememberNavController()
//
//    HabutTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colors.background
//        ) {
//            val gradient = Brush.verticalGradient(
//                0.0f to Violet100,
//                1.0f to Cosmos100,
//                startY = 0.0f,
//                endY = 2800.0f
//            )
//            Box(modifier = Modifier.background(gradient))
//        }
//    }
//
//
//    Column(modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Row(modifier = Modifier
//            .fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween){
//            Row(modifier = Modifier
//                .padding(start = 30.dp, top = 10.dp)
//            ) {
//                CurrentDate()
//            }
//
//            ButtonSettings(navController)
//        }
//
//        Text(modifier = Modifier
//            .padding(top = 20.dp)
//            .height(85.dp),
//            text = "Твои привычки",
//            fontFamily = comfortaa,
//            color = Color.White,
//            fontSize = 30.sp)
//
//        Box(modifier = Modifier.height(480.dp)) {
//            TrackerItemsList(itemList = getListItems())
//        }
//    }
//}


//@Composable
//fun ButtonSettings(navController: NavController){
//    val navController = rememberNavController()
//
//    IconButton(
//        onClick = {
//            navController.navigate(Routes.SETTINGS_SCREEN.route)
//        },
//
//        modifier = Modifier
//            .padding(top = 30.dp, start = 0.dp, end = 30.dp)
//    ) {
//        Icon(
//            Icons.Filled.Settings,
//            modifier = Modifier
//                .size(50.dp),
//            contentDescription = "Настройки",
//            tint = Color.White
//        )
//    }
//}

//
//@Composable
//fun TrackerItemsList(itemList: List<TrackerItems>){
//
//    Column() {
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxWidth(),
//        ) {
//                itemsIndexed(items = itemList,
//                    itemContent = { index, item ->
//                        Card(
//                            modifier = Modifier
//                                .height(80.dp)
//                                .fillMaxWidth()
//                                .padding(start = 22.dp, end = 22.dp, top = 10.dp, bottom = 4.dp)
//                                .clickable {
//
//                                },
//                            shape = RoundedCornerShape(100.dp),
//                            elevation = 5.dp
//                        ) {
//                            Box {
//                                Row(verticalAlignment = Alignment.CenterVertically) {
//                                    Box(
//                                        modifier = Modifier
//                                            .padding(5.dp)
//                                            .size(56.dp)
//                                            .background(color = Violet200, shape = CircleShape)
//                                    ) {
//                                    }
//
//                                    Text(
//                                        text = item.name,
//                                        color = Violet100,
//                                        fontFamily = comfortaa,
//                                        modifier = Modifier.padding(start = 30.dp)
//                                    )
//
//                                }
//                            }
//                        }
//                    })
//            }
//    }
//}
//
//@Composable
//fun CurrentDate(){
//    val calendar = Calendar.getInstance()
//
//    val year = calendar[Calendar.YEAR]
//    val month = calendar[Calendar.MONTH]
//    val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
//
//    var stringMonth: String? = null
//
//
//    Text(
//        text = "$dayOfMonth",
//        style = TextStyle(fontSize = 50.sp),
//        fontFamily = comfortaa,
//        color = Color.White
//    )
//
//    Column(modifier = Modifier
//        .padding(start = 4.dp, top = 20.dp)
//    ){
//
//        Text(
//            text = "$year",
//            style = TextStyle(fontSize = 15.sp),
//            fontFamily = comfortaa,
//            color = Color.White
//        )
//        when (month){
//            4 -> stringMonth = "мая"
//            5 -> stringMonth = "июня"
//            6 -> stringMonth = "июля"
//        }
//        Text(
//            text = "$stringMonth",
//            style = TextStyle(fontSize = 15.sp),
//            fontFamily = comfortaa,
//            color = Color.White
//        )
//
//
//    }
//}


//@Composable
//fun ButtonAdd(navController: NavController) {
//
//    FloatingActionButton(
//        onClick = {
//            navController.navigate(Routes.TRACKER_EDIT.route)
//        },
//        modifier = Modifier.padding(top = 10.dp)
//        ,
//        backgroundColor = Violet200,
//        elevation = FloatingActionButtonDefaults.elevation(
//            defaultElevation = 8.dp,
//            pressedElevation = 12.dp
//        )
//    ) {
//        Icon(imageVector = Icons.Default.Add,
//            contentDescription = "Кнопка добавить",
//            tint = Color.White)
//    }
//}










