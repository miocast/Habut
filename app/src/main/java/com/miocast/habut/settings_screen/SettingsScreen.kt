package com.miocast.habut.settings_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miocast.habut.ui.theme.Cosmos100
import com.miocast.habut.ui.theme.HabutTheme
import com.miocast.habut.ui.theme.Violet100
import com.miocast.habut.ui.theme.comfortaa

@Composable
fun SettingsScreen() {

    val uriHandler = LocalUriHandler.current

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
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .padding(top = 50.dp)
                .height(85.dp),
            text = "Настройки",
            fontFamily = comfortaa,
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )


        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp),
            text = "О нас",
            fontFamily = comfortaa,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Card(
            modifier = Modifier
                .height(60.dp)
                .padding(start = 25.dp, end = 25.dp, top = 10.dp),
            shape = RoundedCornerShape(100.dp),
            elevation = 5.dp
        ) {
            Text(modifier = Modifier
                .clickable {
                    uriHandler.openUri("https://pay.mysbertips.ru/78749717")
                }
                .padding(start = 20.dp, top = 10.dp)
                .fillMaxWidth(),
                text = "Поддержать разработчика",
                fontFamily = comfortaa,
                color = Color.Black,
                fontSize = 14.sp)
        }

        Card(
            modifier = Modifier
                .height(60.dp)
                .padding(start = 25.dp, end = 25.dp, top = 10.dp),
            shape = RoundedCornerShape(100.dp),
            elevation = 5.dp
        ) {
            Text(modifier = Modifier
                .clickable {
                    uriHandler.openUri("https://github.com/miocast/Habut")
                }
                .padding(start = 20.dp, top = 10.dp)
                .fillMaxWidth(),
                text = "Ссылка на GitHub",
                fontFamily = comfortaa,
                color = Color.Black,
                fontSize = 14.sp)
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 40.dp),
            text = "Ссылки",
            fontFamily = comfortaa,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )


        Card(
            modifier = Modifier
                .height(60.dp)
                .padding(start = 25.dp, end = 25.dp, top = 10.dp),
            shape = RoundedCornerShape(100.dp),
            elevation = 5.dp
        ) {
            Text(modifier = Modifier
                .clickable {
                    uriHandler.openUri("https://docs.google.com/document/d/1yBEx20bK4mcAAgPDj_0DjANSYBVCGLBK/edit?usp=sharing&ouid=108924821588183323037&rtpof=true&sd=true")
                }
                .padding(start = 20.dp, top = 10.dp)
                .fillMaxWidth(),
                text = "Руководство пользователя",
                fontFamily = comfortaa,
                color = Color.Black,
                fontSize = 14.sp)
        }


    }

}