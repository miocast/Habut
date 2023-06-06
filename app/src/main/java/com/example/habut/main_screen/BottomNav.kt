package com.example.habut.main_screen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.habut.ui.theme.Violet100

@Composable
fun BottomNav (
    navController: NavHostController
){
    val listItems = listOf(
        BottomNavItem.StatisticsItem,
        BottomNavItem.ListItem,
        BottomNavItem.NoteItem,
        BottomNavItem.SettingItem

    )

    BottomNavigation(
        modifier = Modifier
            .height(105.dp),
        backgroundColor = Color.White) {


        listItems.forEach{ bottomNavItem ->

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            BottomNavigationItem(
                selected = currentRoute == bottomNavItem.route,

                modifier = Modifier.padding(bottom = 50.dp),
                onClick = {
                    navController.navigate(bottomNavItem.route)
                          },
                icon = {
                    Icon(painter = painterResource(id = bottomNavItem.iconId), contentDescription = "Icon")
                },
                label = {
                    Text(
                        text = bottomNavItem.title,
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