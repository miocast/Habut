package com.miocast.habut.new_note_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.miocast.habut.R
import com.miocast.habut.ui.theme.*
import com.miocast.habut.utils.UiEvent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewNoteScreen(
    viewModel: NewNoteViewModel = hiltViewModel(),
    onPopBackStack: () -> Unit
) {

    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect{ uiEvent ->
            when(uiEvent){
                is UiEvent.PopBackStack -> {
                    onPopBackStack()
                }
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        uiEvent.message
                    )
                }
                else -> {}
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState, snackbarHost = {
        SnackbarHost(hostState = scaffoldState.snackbarHostState){ data ->
            Snackbar(
                snackbarData = data,
                backgroundColor = Color.Red
            )
        }
    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Violet100)
        ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            shape = RoundedCornerShape(13.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextField(
                        modifier = Modifier.weight(1f),
                        value = viewModel.title,
                        onValueChange = { text ->
                            viewModel.onEvent(NewNoteEvent.OnTitleChange(text))
                        },
                        label = {
                            Text(
                                text = "Название",
                                fontFamily = comfortaa,
                                fontSize = 14.sp
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                            focusedIndicatorColor = Violet100,
                            unfocusedIndicatorColor = Violet100
                        ),
                        singleLine = true,
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontFamily = comfortaa,
                        )
                    )

                    IconButton(onClick = {
                        viewModel.onEvent(NewNoteEvent.OnSave)
                    }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_save),
                            contentDescription = "Сохранить",
                            tint = Violet100
                        )
                    }
                }

                TextField(
                    modifier = Modifier.fillMaxSize(),
                    value = viewModel.description,
                    onValueChange = { text ->
                        viewModel.onEvent(NewNoteEvent.OnDescriptionChange(text))
                    },
                    label = {
                        Text(
                            text = "Описание",
                            fontFamily = comfortaa,
                            fontSize = 14.sp
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        unfocusedIndicatorColor = Violet100,
                        unfocusedLabelColor = Violet100
                    ),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontFamily = comfortaa,
                    )
                )

            }


        }
        }

    }


}