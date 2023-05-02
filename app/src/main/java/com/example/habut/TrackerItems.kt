package com.example.habut

data class TrackerItems(
    //все, что содержит карточка трекера
    val name: String)

fun getListItems() = listOf(
    TrackerItems("Чтение"),
    TrackerItems("Медитация"),
    TrackerItems("Зарядка")
)