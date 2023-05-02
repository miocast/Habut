package com.example.habut.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun StatisticsScreen(){
    Text(
        modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "Страница статистики",
        textAlign = TextAlign.Center
    )
}