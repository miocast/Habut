//класс model
package com.example.habut

data class TrackerItems(
    //все, что содержит карточка трекера
    val id_tracker: Int,
    val name: String)

//sealed class TrackerItemsEvent{
//    data class
//}

fun getListItems() = listOf(
    TrackerItems(1,"Чтение"),
    TrackerItems(2,"Медитация"),
    TrackerItems(3,"Зарядка"),
    TrackerItems(4,"Аапвп"),
    TrackerItems(5,"Миывпвп"),
    TrackerItems(6,"Ваприис"),
    TrackerItems(3,"Зарядка"),
    TrackerItems(4,"Аапвп"),
    TrackerItems(5,"Миывпвп"),
    TrackerItems(6,"Ваприис"),


)
