package com.example.habut.items

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habut.TrackerItems


@Composable
fun SleepTrackerItem(){


    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 30.dp, bottom = 30.dp)
            .width(400.dp)
            .height(570.dp)
            .background(color = Color.Red)
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState())

        ,
        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(){
            Text(
                modifier = Modifier
                    .padding(top = 10.dp, start = 40.dp, end = 10.dp)
                    .background(color = Color.Green)
                ,
                text = "20 21 22 23 00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 ",
                color = Color.White,
                fontSize = 16.sp,
            )


            //slider
        }

        //дата
        Row(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .width(25.dp)
            .background(color = Color.Blue)
        ){
            Text(
                textAlign = TextAlign.Center,
                text = "1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n30\n31",
                fontSize = 16.sp,
                color = Color.White
            )
        }


    }
}


