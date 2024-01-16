package com.navigation.voyager.component.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.core.screen.Screen
import com.navigation.voyager.screen.HomeA
import com.navigation.voyager.screen.HomeB
import com.navigation.voyager.screen.HomeC

enum class BottomBarDestination(
    val direction: Screen,
    val icon: ImageVector,
    val label: String
) {
    HomeATab(HomeA, Icons.Default.Home, "Home A"),
    HomeBTab(HomeB, Icons.Default.Home, "Home B"),
    HomeCTab(HomeC, Icons.Default.Home, "Home C")
}