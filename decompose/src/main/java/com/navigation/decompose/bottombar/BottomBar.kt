package com.navigation.decompose.bottombar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import com.navigation.decompose.RootComponent

@Composable
fun BottomBar(
    selectedScreen: RootComponent.Child,
    navigateLaterally: (RootComponent.Config.Home) -> Unit
) {
    BottomNavigation {
        BottomNavigationItem(
            selected = selectedScreen is RootComponent.Child.HomeA,
            onClick = { navigateLaterally(RootComponent.Config.Home.HomeA) },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
            label = { Text(text = "Home A") }
        )
        BottomNavigationItem(
            selected = selectedScreen is RootComponent.Child.HomeB,
            onClick = { navigateLaterally(RootComponent.Config.Home.HomeB) },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
            label = { Text(text = "Home B") }
        )
        BottomNavigationItem(
            selected = selectedScreen is RootComponent.Child.HomeC,
            onClick = { navigateLaterally(RootComponent.Config.Home.HomeC) },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
            label = { Text(text = "Home C") }
        )
    }
}