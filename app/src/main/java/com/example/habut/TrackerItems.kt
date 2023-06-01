//класс model
package com.example.habut

import com.example.habut.Repository.Tracker

data class TrackerItems(
    //все, что содержит карточка трекера
    val id_tracker: Int,
    val name: String)



fun getListItems() = listOf(
    TrackerItems(2,"Медитация"),
    TrackerItems(3,"Зарядка"),
    TrackerItems(4,"Полив цветка"),
    TrackerItems(5,"Йога"),
    TrackerItems(6,"Маска"),
    TrackerItems(4,"Чтение"),
    TrackerItems(5,"Прогулка"),
    TrackerItems(6,"Английский"),

)
