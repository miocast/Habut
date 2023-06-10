package com.example.habut.utils

sealed class UiEvent{
    object PopBackStack: UiEvent()
    data class Navigate(val route: String): UiEvent()
    data class NavigateMain(val route: String): UiEvent()
//    data class ShowSnackBar(val message: String): UiEvent()

}
