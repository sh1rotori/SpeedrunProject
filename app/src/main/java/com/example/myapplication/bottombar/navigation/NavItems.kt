package com.example.myapplication.bottombar.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItems = listOf(
    NavItem(
        label = "Today",
        icon = Icons.Default.DateRange,
        route = Screens.Today.name
    ),
    NavItem(
        label = "All",
        icon = Icons.Default.List,
        route = Screens.allTasks.name
    ),
    NavItem(
        label = "Completed",
        icon = Icons.Default.Check,
        route = Screens.Completed.name
    ),
    NavItem(
        label = "Favorites",
        icon = Icons.Default.Favorite,
        route = Screens.Favorites.name
    ),
    NavItem(
        label = "New Task",
        icon = Icons.Default.Create,
        route = Screens.newTask.name
    ),
    NavItem(
        label = "Profile",
        icon = Icons.Default.AccountBox,
        route = Screens.Profile.name
    ),
)