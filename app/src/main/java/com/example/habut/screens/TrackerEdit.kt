package com.example.habut.screens

import android.graphics.Paint.Align
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habut.ui.theme.Violet100

@Composable
fun TrackerEdit(
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
                        .padding(top = 20.dp)
//                        .padding(top = -5.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){


                        Text(
                            modifier = Modifier
                                .padding(start = 40.dp)
//                                .fillMaxWidth()
                            ,
                            text = "Создание трекера",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                        Icon(
                            modifier = Modifier
//                                .fillMaxWidth()
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

                    TextFieldView()


                    Button(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth()
                            .height(50.dp),
                        onClick = {
                            confirmButtonClicked(
//                            название
//                            напоминание
//                            описание
                            )
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


                    //textfield и label

                }
            },


            buttons = {
                Column(
                ) {

                }
            },

            onDismissRequest = {
            }
        )
    }
}


@Composable
fun TextFieldView(){
    val nameState = remember { mutableStateOf("")}
    val notificationState = remember { mutableStateOf("")}
    val descriptionState = remember { mutableStateOf("")}
    
    Column(modifier = Modifier
//        .height(80.dp)
        .padding(top = 30.dp, bottom = 4.dp)
    ) {
        OutlinedTextField(value = nameState.value,modifier = Modifier
//        .height(80.dp)
            .padding(bottom = 10.dp),

            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                nameState.value = it
            },
            label = {
                Text(text = "Название")
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Violet100,
                unfocusedBorderColor = Color.Gray)

        )

        OutlinedTextField(value = notificationState.value,
            modifier = Modifier
//        .height(80.dp)
                .padding(bottom = 10.dp),
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                notificationState.value = it
            },
            label = {
                Text(text = "Напоминание")
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Violet100,
                unfocusedBorderColor = Color.Gray))

        OutlinedTextField(
            value = descriptionState.value,
            modifier = Modifier
                .padding(bottom = 10.dp)
                .height(150.dp),
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                descriptionState.value = it
            },
            label = {
                Text(text = "Описание")
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Violet100,
                unfocusedBorderColor = Color.Gray)

        )
    }

}