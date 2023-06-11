package com.miocast.habut.tracker_screen

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
import com.miocast.habut.data.TrackerItem
import com.miocast.habut.data.TrackerListItem
import com.miocast.habut.tracker_list_screen.TrackerListEvent
import com.miocast.habut.ui.theme.Gray100
import com.miocast.habut.ui.theme.Violet200
import com.miocast.habut.R

@Composable
fun UiTrackerItem(
    item: TrackerItem,
    onEvent: (TrackerEvent) -> Unit
) {



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
            tint = if (item.isDone) Color(0xFF03DAC5) else Color(0xFFB0BEC5)
        )
    }

}