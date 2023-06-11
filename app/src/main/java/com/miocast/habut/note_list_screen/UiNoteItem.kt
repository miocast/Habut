package com.miocast.habut.note_list_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miocast.habut.data.NoteItem
import com.miocast.habut.ui.theme.Scarlet100
import com.miocast.habut.ui.theme.Violet100
import com.miocast.habut.ui.theme.comfortaa
import com.miocast.habut.utils.Routes


@Composable
fun UiNoteItem(
    item: NoteItem,
    onEvent: (NoteListEvent) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(start = 10.dp, end = 10.dp, top = 5.dp)
            .clickable {
                onEvent(
                    NoteListEvent.OnItemClick(
                        Routes.NEW_NOTE + "/${item.id}"
                    )
                )
            },
        shape = RoundedCornerShape(11.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, top = 10.dp)
                        .weight(1f),
                    text = item.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    color = Violet100,
                    fontFamily = comfortaa,
                )
                Text(
                    modifier = Modifier
                        .padding(end = 12.dp, top = 16.dp),
                    text = item.time,
                    color = Violet100,
                    fontSize = 12.sp
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 5.dp, bottom = 10.dp)
                        .weight(1f)
                    ,
                    text = item.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray,
                    fontSize = 12.sp
                )

                IconButton(
                    onClick = {
                        onEvent(NoteListEvent.OnShowDeleteDialog(item))

                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Удалить трекер",
                        tint = Scarlet100
                    )

                }
            }
        }
    }
}