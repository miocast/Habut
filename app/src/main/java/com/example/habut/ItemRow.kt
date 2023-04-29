package com.example.habut

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.habut.ui.theme.Cosmos100
import com.example.habut.ui.theme.Violet100
import com.example.habut.ui.theme.Violet200
import com.example.habut.ui.theme.comfortaa

@Composable
fun ItemRow(item: ItemRowModel){
    Card(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .padding(start = 22.dp, end = 22.dp, top = 10.dp, bottom = 4.dp)
            .clickable {
                Log.d("MyLog", "Жмакнули")
            },
        shape = RoundedCornerShape(100.dp),
        elevation = 5.dp
    ) {
        Box {
            Row (verticalAlignment = Alignment.CenterVertically){

                var color = remember {
                    mutableStateOf(Violet200)
                }

                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .size(56.dp)
                        .background(color = color.value, shape = CircleShape)
                        .clickable {
                            color.value = Cosmos100
                        }
                )
                Text(text = item.title, color = Violet100,fontFamily = comfortaa, modifier = Modifier.padding(start = 30.dp))
            }
        }
    }
}