package com.example.habut.ui_components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.habut.ui.theme.Violet100
import com.example.habut.ui.theme.Violet200


@Composable
fun BottomNavigationBar(navController: NavController){

    val listItems = listOf(
        BottomItem.StatisticsScreen,
        BottomItem.MainScreen,
        BottomItem.SleepTrackerScreen
    )

    BottomNavigation(
        modifier = Modifier
            .height(105.dp)

        ,
        backgroundColor = Color.White
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItems.forEach{ item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                modifier = Modifier.padding(bottom = 50.dp),
                onClick = {
                    navController.navigate(item.route) },
                icon = {
                    Icon(painter = painterResource(id = item.iconId), contentDescription = "Icon")
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 10.sp
                    )
                },
                alwaysShowLabel = false,
                selectedContentColor = Violet100,
                unselectedContentColor = Color.Gray

                )
            }
        }
    }
