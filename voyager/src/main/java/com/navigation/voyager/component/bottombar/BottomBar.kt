package com.navigation.voyager.component.bottombar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator

@Composable
fun BottomBar(navigator: Navigator) {
    BottomNavigation {
        BottomBarDestination.values().forEach { destination ->
            BottomNavigationItem(
                selected = navigator.lastItem == destination.direction,
                onClick = {
                    navigator.popUntil { navigator.size == 1 }
                    if (navigator.lastItem != destination.direction) {
                        navigator push destination.direction
                    }
                },
                icon = { Icon(destination.icon, contentDescription = destination.label)},
                label = { Text(destination.label) }
            )
        }
    }
}