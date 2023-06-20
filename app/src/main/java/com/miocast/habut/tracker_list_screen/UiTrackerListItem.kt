package com.miocast.habut.tracker_list_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.miocast.habut.data.TrackerListItem
import com.miocast.habut.ui.theme.*
import com.miocast.habut.utils.Routes


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
                onEvent(
                    TrackerListEvent.OnItemClick(
                        Routes.TRACKER_ITEM + "/${item.id}"
                    )
                )
            },
        shape = RoundedCornerShape(100.dp)

    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(top = 7.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {


                Checkbox(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(start = 20.dp),
                    checked = item.isCheck,
                    onCheckedChange = { isChecked ->
                        onEvent(TrackerListEvent.OnCheckedChange(item.copy(isCheck = isChecked)))
                    }
                )

                Text(
                    modifier = Modifier
                        .padding(bottom = 0.dp, top = 0.dp, start = 30.dp)
                        .weight(1f)
                        .fillMaxWidth()
                        ,
                    text = item.name,
                    textAlign = TextAlign.Start,
                    color = Violet100,
                    fontFamily = comfortaa,
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
                    modifier = Modifier
                        .padding(end = 20.dp),
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






