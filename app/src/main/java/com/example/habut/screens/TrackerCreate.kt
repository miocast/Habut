package com.example.habut.screens

import android.app.TimePickerDialog
import android.icu.util.Calendar
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habut.ui.theme.Violet100
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import com.example.habut.ui.theme.Violet200

@Composable
fun TrackerCreate(
//    trackerViewModel: TrackerViewModel,
    visible: Boolean,
    closeClicked: () -> Unit,
    confirmButtonClicked: () -> Unit
) {

    if (visible) {
        AlertDialog(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(5),
            title = null,
            text = {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){

                        Text(
                            modifier = Modifier
                                .padding(start = 40.dp),
                            text = "Создание трекера",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )

                        Icon(
                            modifier = Modifier
                                .size(25.dp)
                                .clickable(
                                    onClick = {
                                        closeClicked()
                                    }
                                ),
                            imageVector = Icons.Filled.Close,
                            contentDescription = null
                        )
                    }

                    var nameState = remember {
                        TextFieldState()
                    }

                    Column(modifier = Modifier
                        .padding(top = 30.dp, bottom = 4.dp)
                    ) {
                        TextFieldName(nameState)
                    }


                    Button(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth()
                            .height(50.dp),
                        onClick = {

                            confirmButtonClicked()


//                            confirmButtonClicked(
//                                trackerViewModel.addTracker(
//                                Tracker(
//                                      id = 1,
//                                    trackerName = "name",
//                                )
//                                )
//                            )

                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Violet100),
                        shape = RoundedCornerShape(10.dp)

                    ) {
                        Text(
                            text = "Сохранить",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                }
            },

            buttons = {},

            onDismissRequest = {}
        )
    }
}

class TextFieldState(){
    var text: String by mutableStateOf("")
}

@Composable
fun TextFieldName(nameState: TextFieldState = remember { TextFieldState() }){

        OutlinedTextField(
            value = nameState.text,
            modifier = Modifier
            .padding(bottom = 10.dp),

            shape = RoundedCornerShape(10.dp),
            onValueChange = {

                nameState.text = it
            },
            label = {
                Text(text = "Название")
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Violet100,
                unfocusedBorderColor = Color.Gray)
        )
}

@Composable
fun TimePicker(){
    val calendar = Calendar.getInstance()
    val hour = calendar[Calendar.HOUR_OF_DAY]
    val minute = calendar[Calendar.MINUTE]

    val context = LocalContext.current

    val time = remember { mutableStateOf("") }
    val timePickerDialog = TimePickerDialog(
        context,
        {_, hour : Int, minute: Int ->
            time.value = "$hour:$minute"
        }, hour, minute, true
    )

    Column (
        modifier = Modifier
//        .fillMaxWidth(),
//        horizontalAlignment = Alignment.Start
//        verticalArrangement = Arrangement.Center
    ){
        OutlinedButton(
            modifier = Modifier
                .height(52.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, color = Color.Gray),
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
            onClick = {
            timePickerDialog.show()
            })
        {
            Text(
                text = "${time.value}",
                color = Color.Gray)
        }
    }
}


@Composable
fun enablingButton(){
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var label = remember { mutableStateOf("Выкл.  ")}
    var color = remember {
        mutableStateOf(Violet200)
    }


    Button(
                modifier = Modifier
                    .height(52.dp),
                shape = RoundedCornerShape(10.dp),
        onClick = {
            isExpanded = !isExpanded
        })
    {
//        if(isExpanded) color.value = Violet200 else color.value = Cosmos100

        if(isExpanded) label.value = "Вкл. " else label.value = "Выкл. "
        Text(label.value + "уведомления")
    }
}


//@Composable
//fun TextFieldView(){
//
//    val nameState = remember { mutableStateOf("")}
//
//    val descriptionState = remember { mutableStateOf("")}
//
//    Column(modifier = Modifier
//        .padding(top = 30.dp, bottom = 4.dp)
//    ) {
//        OutlinedTextField(value = nameState.value,modifier = Modifier
//            .padding(bottom = 10.dp),
//
//            shape = RoundedCornerShape(10.dp),
//            onValueChange = {
//                nameState.value = it
//            },
//            label = {
//                Text(text = "Название")
//            },
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedBorderColor = Violet100,
//                unfocusedBorderColor = Color.Gray)
//
//        )
//
//        OutlinedTextField(
//            value = descriptionState.value,
//            modifier = Modifier
//                .padding(bottom = 10.dp)
//                .height(150.dp),
//            shape = RoundedCornerShape(10.dp),
//            onValueChange = {
//                descriptionState.value = it
//            },
//            label = {
//                Text(text = "Описание")
//            },
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedBorderColor = Violet100,
//                unfocusedBorderColor = Color.Gray)
//        )
//
//    }
//    Row {
//
//        TimePicker()
//        enablingButton()
//
//    }
//}