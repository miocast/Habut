package com.example.habut.screens

import android.icu.util.Calendar
import android.widget.NumberPicker
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habut.items.SleepTrackerItem
import com.example.habut.ui.theme.*
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import java.time.Month

@Composable
fun SleepTrackerScreen(){
    HabutTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val gradient = Brush.verticalGradient(
                0.0f to Night100,
                1.0f to Violet100,
                startY = 0.0f,
                endY = 2000.0f
            )
            Box(modifier = Modifier.background(gradient))
        }
    }


    var visible by remember {
        mutableStateOf(false)
    }

    val currentMonth = Calendar.getInstance().get(Calendar.MONTH)

    val year = Calendar.getInstance().get(Calendar.YEAR)
    var date by remember {
        mutableStateOf("${currentMonth + 1}/$year")
    }



//    val openDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
//        verticalArrangement = Arrangement.Center
    ) {
        Text(modifier = Modifier
            .padding(top = 50.dp)
            .height(85.dp),
            text = "Трекер сна",
            fontFamily = comfortaa,
            color = Color.White,
            fontSize = 30.sp)



        MonthPicker(
            visible = visible,
            currentMonth = currentMonth,
            currentYear = year,
            confirmButtonClicked = { month_, year_ ->

                date = "$month_/$year_"
                visible = false
            },
            cancelClicked = {
                visible = false
            }
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
            .width(180.dp)
            .fillMaxWidth()
            .padding(start = 16.dp)
            .background(
                color = Violet100,
                shape = CircleShape
            )
            .clickable { visible = true }

        ){
            Text(
                text = date,

                color = Color.White,
                fontSize = 25.sp,
                fontFamily = comfortaa,
                textAlign = TextAlign.Center,
            )
        }

        SleepTrackerItem()


    }
}

@Composable
fun MonthPicker(
    visible: Boolean,
    currentMonth: Int,
    currentYear: Int,
    confirmButtonClicked: (Int, Int) -> Unit,
    cancelClicked: () -> Unit){
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
//    val openDialog = remember { mutableStateOf(false) }

    var month by remember {
        mutableStateOf(months[currentMonth])
    }


    var year by remember {
        mutableStateOf(currentYear)
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

//    Button(
//        onClick = { openDialog.value = true }
//    ) {
//        Text("Удалить", fontSize = 22.sp)
//    }
    
    if (visible) {

        AlertDialog(
            backgroundColor = Color.White,
            shape = RoundedCornerShape(10),
            title = {
            },



            text = {
                   Column() {
                       Row(modifier = Modifier.fillMaxWidth(),
                       horizontalArrangement = Arrangement.Center,
                       verticalAlignment = Alignment.CenterVertically
                       ) {
                           Icon(
                               modifier = Modifier
                                   .size(35.dp)
                                   .rotate(90f)
                                   .clickable(
                                       indication = null,
                                       interactionSource = interactionSource,
                                       onClick = {
                                           year--
                                       }
                                   ),

                               imageVector = Icons.Rounded.KeyboardArrowDown,
                               contentDescription = null
                           )

                           Text(
                               modifier = Modifier.padding(horizontal = 20.dp),
                               text = year.toString(),
                               fontSize = 24.sp,
                               fontWeight = FontWeight.Bold
                           )

                           Icon(
                               modifier = Modifier
                                   .size(35.dp)
                                   .rotate(-90f)
                                   .clickable(
                                       indication = null,
                                       interactionSource = interactionSource,
                                       onClick = {
                                           year++
                                       }
                                   ),

                               imageVector = Icons.Rounded.KeyboardArrowDown,
                               contentDescription = null
                           )
                       }

                       Card(modifier = Modifier
                           .padding(top = 30.dp)
                           .fillMaxWidth(),
                           elevation = 0.dp
                       ) {
                           FlowRow(
                               modifier = Modifier.fillMaxWidth(),
                               mainAxisSpacing = 16.dp,
                               crossAxisSpacing = 16.dp,
                               mainAxisAlignment = MainAxisAlignment.Center,
                               crossAxisAlignment = FlowCrossAxisAlignment.Center,

                           ){
                               months.forEach{
                                   Box(modifier = Modifier
                                       .size(60.dp)
                                       .clickable(
                                           indication = null,
                                           interactionSource = interactionSource,
                                           onClick = {
                                               month = it
                                           }
                                       )
                                       .background(color = Color.Transparent),
                                       contentAlignment = Alignment.Center
                                   ){
                                       val animatedSize by animateDpAsState(
                                           targetValue = if (month == it) 60.dp else 0.dp,
                                           animationSpec = tween(
                                               durationMillis = 500,
                                               easing = LinearOutSlowInEasing
                                           )
                                       )

                                       Box(
                                           modifier = Modifier
                                               .size(animatedSize)
                                               .background(
                                                   color = if (month == it) Violet100 else Color.Transparent,
                                                   shape = CircleShape
                                               )
                                       )

                                       Text(
                                           text = it,
                                           color = if (month == it) Color.White else Color.Black
                                       )
                                   }
                               }
                           }
                       }

                   }
            },

            buttons = {

                      Row(modifier = Modifier
                          .fillMaxWidth()
                          .padding(end = 20.dp, bottom = 30.dp),
                          horizontalArrangement = Arrangement.End){

                          OutlinedButton(
                              modifier = Modifier.padding(end = 20.dp),
                              onClick = {
                                  cancelClicked()
                              },
                              shape = CircleShape,
                              border = BorderStroke(1.dp, color = Color.Transparent),
                              colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent)
                          ) {
                              Text(
                                  text = "Отменить",
                                  color = Color.Black,
                                  fontSize = 20.sp,
                                  fontWeight = FontWeight.Medium
                              )
                          }


                          OutlinedButton(
                              modifier = Modifier.padding(end = 20.dp),
                              onClick = {
                                  confirmButtonClicked(
                                      months.indexOf(month) + 1,
                                      year
                                  )
                              },
                              shape = CircleShape,
                              border = BorderStroke(1.dp, color = Violet100),
                              colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent)
                          ) {
                              Text(
                                  text = "OK",
                                  color = Violet100,
                                  fontSize = 20.sp,
                                  fontWeight = FontWeight.Medium
                              )
                          }





                      }
            },
            onDismissRequest = {
            }
        )
    }
}

//@Composable
//fun Month(){
//    val calendar = Calendar.getInstance()
//    val month = calendar[Calendar.MONTH]
//
//    var stringMonth: String? = null
//
//    when (month){
//        4 -> stringMonth = "Май"
//        5 -> stringMonth = "Июнь"
//        6 -> stringMonth = "Июль"
//    }
//    Text(
//        text = "$stringMonth",
//        style = TextStyle(fontSize = 15.sp),
//        fontFamily = comfortaa,
//        color = Color.White
//    )
//}


//var stringMonth: String? = null
//
//when (months.indexOf(month)){
//    0 -> stringMonth = "Январь"
//    1 -> stringMonth = "Февраль"
//    2 -> stringMonth = "Март"
//    3 -> stringMonth = "Апрель"
//    4 -> stringMonth = "Май"
//    5 -> stringMonth = "Июнь"
//    6 -> stringMonth = "Июль"
//    7 -> stringMonth = "Август"
//    8 -> stringMonth = "Сентябрь"
//    9 -> stringMonth = "Октябрь"
//    10 -> stringMonth = "Ноябрь"
//    11 -> stringMonth = "Декабрь"
//}

