package com.navigation.destinations.component.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.navigation.destinations.screen.destinations.HomeADestination
import com.navigation.destinations.screen.destinations.HomeBDestination
import com.navigation.destinations.screen.destinations.HomeCDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    val icon: ImageVector,
    val label: String
) {
    HomeA(HomeADestination, Icons.Default.Home, "Home A"),
    HomeB(HomeBDestination, Icons.Default.Home, "Home B"),
    HomeC(HomeCDestination, Icons.Default.Home, "Home C")
}