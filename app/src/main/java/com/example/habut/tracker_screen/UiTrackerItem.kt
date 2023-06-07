package com.example.habut.tracker_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.habut.data.TrackerItem
import com.example.habut.data.TrackerListItem
import com.example.habut.tracker_list_screen.TrackerListEvent
import com.example.habut.ui.theme.Gray100
import com.example.habut.ui.theme.Violet200

@Composable
fun UiTrackerItem(
    item: TrackerItem,
    onEvent: (TrackerEvent) -> Unit
) {


    var isExpanded by remember { mutableStateOf(true) }

    var color = remember {
        mutableStateOf(Gray100)
    }

    Box(
        modifier = Modifier
            .padding(5.dp)
            .size(56.dp)
            .background(
                color = color.value,
                shape = CircleShape
            )
            .clickable {
//                    isChecked ->
//                onEvent(TrackerEvent.OnCheckedChange())

                isExpanded = !isExpanded
                //onEvent
            }
    ) {
        if(isExpanded)
            color.value = Gray100

        else
            color.value = Violet200
    }
}