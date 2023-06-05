//класс model
package com.example.habut



data class TrackerItems(
    val id_tracker: Int,
    val name: String)



fun getListItems() = listOf(
    TrackerItems(1, "Чтение"),
    TrackerItems(2, "Йога"),
    TrackerItems(3, "Медитация"),
    )


