package com.example.habut.tracker_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.habut.data.TrackerListItem
import com.example.habut.dialog.MainDialog
import com.example.habut.ui.theme.*
import com.example.habut.utils.Routes
import java.util.*


@Composable
fun UiTrackerListItem(
    item: TrackerListItem,
    onEvent: (TrackerListEvent) -> Unit
) {
    Card(
        modifier = Modifier
            .height(80.dp)
            .padding(start = 22.dp, end = 22.dp, top = 10.dp, bottom = 4.dp)
            .clickable {
//            navController.navigate(Routes.TrackerScreen.route)
            },
        shape = RoundedCornerShape(100.dp)

    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {


                Box(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp)
                        .size(56.dp)
                ) {
                    Checkbox(
                        checked = item.isCheck,
                        onCheckedChange = { isChecked ->
//                        onEvent(AddItemEvent.OnCheckedChange(item.copy(isCheck = isChecked)))
                        }
                    )
                }


                // CHECKBOX


//                Box(
//                    modifier = Modifier
//                        .padding(5.dp)
//                        .size(56.dp)
//                        .background(
//                            color = Violet200,
//                            shape = CircleShape
//                        )
//                        .clickable {}
//                ) {}

                Text(
                    modifier = Modifier
                        .width(190.dp)
                        .fillMaxWidth()
                        .padding(bottom = 5.dp, start = 20.dp),
                    text = item.name,
                    textAlign = TextAlign.Start,
                    color = Violet100,
                    fontFamily = comfortaa
                )

                IconButton(
                    onClick = {
                        onEvent(TrackerListEvent.OnShowEditDialog(item))
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Изменить трекер"
                    )
                }

                IconButton(
                    onClick = {
                        onEvent(TrackerListEvent.OnShowDeleteDialog(item))
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Удалить трекер"
                    )
                }
            }
        }
    }


}






