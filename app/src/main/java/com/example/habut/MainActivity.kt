package com.example.habut

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.habut.Repository.Tracker
import com.example.habut.Repository.TrackerViewModel
import com.example.habut.screens.MainScreen
import com.example.habut.screens.SettingsScreen
import com.example.habut.screens.TrackerEdit
import com.example.habut.ui.theme.*
import com.example.habut.ui_components.BottomNavigationBar
import com.example.habut.ui_components.NavGraph
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, )
    {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BotBarNav()
        }
    }
}

//@Composable
//fun TrackerList(trackerViewModel: TrackerViewModel) {
//
//
//    val trackerList = trackerViewModel.getTrackers()
//
//    FloatingActionButton(
//        onClick = {
//            val name = UUID.randomUUID().toString()
//            trackerViewModel.insertTracker(
//                Tracker(
//                    name = name,
//                    notification = "Male",
//                    description = "xyz@gmail.com"
//                ),
//            )
//        },
//        modifier = Modifier.padding(top = 10.dp)
//        ,
//        backgroundColor = Violet200,
//        elevation = FloatingActionButtonDefaults.elevation(
//            defaultElevation = 8.dp,
//            pressedElevation = 12.dp
//        )
//    ) {
//        Icon(imageVector = Icons.Default.Add,
//            contentDescription = "Кнопка добавить",
//            tint = Color.White)
//    }
//
//}






@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BotBarNav(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {
        NavGraph(navController = navController)
    }
}



