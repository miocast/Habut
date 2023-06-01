package com.example.habut.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habut.ui.theme.*

@Composable
fun SettingsScreen(){
    HabutTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val gradient = Brush.verticalGradient(
                0.0f to Violet100,
                1.0f to Cosmos100,
                startY = 0.0f,
                endY = 2800.0f
            )
            Box(modifier = Modifier.background(gradient))
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 100.dp, top = 50.dp)
            .height(85.dp),
            text = "Настройки",
            fontFamily = comfortaa,
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold)


        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp),
            text = "Поделиться",
            fontFamily = comfortaa,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp)

        Card(modifier = Modifier
            .height(60.dp)
            .padding(start = 25.dp, end = 25.dp, top = 10.dp),
            shape = RoundedCornerShape(100.dp),
            elevation = 5.dp
        ){
            Text(modifier = Modifier
                .padding(start = 20.dp, top = 10.dp)
                .fillMaxWidth(),
                text = "Оценить",
                fontFamily = comfortaa,
                color = Color.Black,
                fontSize = 14.sp)
        }

        Card(modifier = Modifier
            .height(60.dp)
            .padding(start = 25.dp, end = 25.dp, top = 10.dp),
            shape = RoundedCornerShape(100.dp),
            elevation = 5.dp
        ){
            Text(modifier = Modifier
                .padding(start = 20.dp, top = 10.dp)
                .fillMaxWidth(),
                text = "Сообщить об ошибке",
                fontFamily = comfortaa,
                color = Color.Black,
                fontSize = 14.sp)
        }

        Card(modifier = Modifier
            .height(60.dp)
            .padding(start = 25.dp, end = 25.dp, top = 10.dp),
            shape = RoundedCornerShape(100.dp),
            elevation = 5.dp
        ){
            Text(modifier = Modifier
                .padding(start = 20.dp, top = 10.dp)
                .fillMaxWidth(),
                text = "Поделиться",
                fontFamily = comfortaa,
                color = Color.Black,
                fontSize = 14.sp)
        }

        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 40.dp),
            text = "Ссылки",
            fontFamily = comfortaa,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp)

        Card(modifier = Modifier
            .height(60.dp)
            .padding(start = 25.dp, end = 25.dp, top = 10.dp),
            shape = RoundedCornerShape(100.dp),
            elevation = 5.dp
        ){
            Text(modifier = Modifier
                .padding(start = 20.dp, top = 10.dp)
                .fillMaxWidth(),
                text = "Политика конфиденциальности",
                fontFamily = comfortaa,
                color = Color.Black,
                fontSize = 14.sp)
        }

        Card(modifier = Modifier
            .height(60.dp)
            .padding(start = 25.dp, end = 25.dp, top = 10.dp),
            shape = RoundedCornerShape(100.dp),
            elevation = 5.dp
        ){
            Text(modifier = Modifier
                .padding(start = 20.dp, top = 10.dp)
                .fillMaxWidth(),
                text = "Руководство пользователя",
                fontFamily = comfortaa,
                color = Color.Black,
                fontSize = 14.sp)
        }


        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 40.dp),
            text = "Выйти из аккаунта",
            fontFamily = comfortaa,
            color = Scarlet100,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp)

    }




}