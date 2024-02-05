package com.example.myapplication.bottombar.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.bottombar.screens.Completed
import com.example.myapplication.bottombar.screens.Favorites
import com.example.myapplication.bottombar.screens.Profile
import com.example.myapplication.bottombar.screens.Today
import com.example.myapplication.bottombar.screens.allTasks
import com.example.myapplication.bottombar.screens.newTask


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation (){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                
                listOfNavItems.forEach{navItem ->  
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any{it.route == navItem.route} == true,
                        onClick = {
                                  navController.navigate(navItem.route){
                                      popUpTo(navController.graph.findStartDestination().id){
                                          saveState = true
                                      }
                                      launchSingleTop = true
                                      restoreState = true
                                  }
                        },
                        icon = {
                               Icon(imageVector = navItem.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.allTasks.name,
            modifier = Modifier
                .padding(paddingValues)
        )   {
            composable(route = Screens.allTasks.name){
                allTasks()
            }
            composable(route = Screens.Completed.name){
                Completed()
            }
            composable(route = Screens.Favorites.name){
                Favorites()
            }
            composable(route = Screens.newTask.name){
                newTask()
            }
            composable(route = Screens.Profile.name){
                Profile()
            }
            composable(route = Screens.Today.name){
                Today()
            }

        }
    }
}