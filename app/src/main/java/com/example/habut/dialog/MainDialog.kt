package com.example.habut.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habut.ui.theme.Gray100
import com.example.habut.ui.theme.Violet100
import com.example.habut.ui.theme.comfortaa

@Composable
fun MainDialog(
    dialogController: DialogController
){
    val maxLength = 5

    if (dialogController.openDialog.value){
        AlertDialog(onDismissRequest = {
            dialogController.onDialogEvent(DialogEvent.OnCancel)
        },
            title = null,
            text = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = dialogController.dialogTitle.value,
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            fontFamily = comfortaa
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    if (dialogController.showEditableText.value)

                        TextField(
                        value = dialogController.editableText.value,
                        onValueChange = {text ->
                            dialogController.onDialogEvent(DialogEvent.OnTextChange(text))
                        },

                        label = {
                            Text(text = "Название")
                        },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Gray100,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(10.dp),
                            singleLine = true
                    )
                }
            },

            confirmButton = {
                TextButton(onClick = {
                    dialogController.onDialogEvent(DialogEvent.OnConfirm)
                }) {
                    Text(
                        text = "Подтвердить",
                        color = Violet100)
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    dialogController.onDialogEvent(DialogEvent.OnCancel)
                }) {
                    Text(
                        text = "Отменить",
                        color = Violet100)
                }
            }
        )
    }
}