package com.navigation.destinations.component.bottombar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.navigation.destinations.screen.NavGraphs
import com.navigation.destinations.screen.appCurrentDestinationAsState
import com.navigation.destinations.screen.destinations.Destination
import com.navigation.destinations.screen.startAppDestination
import com.ramcosta.composedestinations.navigation.navigate

@Composable
fun BottomBar(navController: NavController) {
    val currentDestination: Destination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination

    BottomNavigation {
        BottomBarDestination.values().forEach { destination ->
            BottomNavigationItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigate(destination.direction) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                },
                icon = { Icon(destination.icon, contentDescription = destination.label)},
                label = { Text(destination.label) }
            )
        }
    }
}