package com.example.habut.tracker_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.habut.data.TrackerItem
import com.example.habut.data.TrackerListItem
import com.example.habut.tracker_list_screen.TrackerListEvent
import com.example.habut.ui.theme.Gray100
import com.example.habut.ui.theme.Violet200
import com.example.habut.R

@Composable
fun UiTrackerItem(
    item: TrackerItem,
    onEvent: (TrackerEvent) -> Unit
) {


    var color = remember {
        mutableStateOf(Gray100)
    }


    IconToggleButton(
        modifier = Modifier.size(50.dp),
        checked = item.isDone,
        onCheckedChange = { isChecked ->
            onEvent(TrackerEvent.OnCheckedChange(item.copy(isDone = isChecked)))
        }
    ) {
        Icon(
            modifier = Modifier.size(50.dp),
            painter = painterResource(id = R.drawable.icon_circle),
            contentDescription = "Информация о приложении",
            tint = if (item.isDone) Color(0xFFEC407A) else Color(0xFFB0BEC5)
        )
    }

}