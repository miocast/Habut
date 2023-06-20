package com.miocast.habut.utils

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

fun ViewModel.getCurrentTime(): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    val cv = Calendar.getInstance()
    return formatter.format(cv.time)
}