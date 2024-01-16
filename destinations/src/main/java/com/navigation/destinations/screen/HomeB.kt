package com.navigation.destinations.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.navigation.destinations.component.bottombar.BottomBarState
import com.navigation.destinations.component.topbar.TopBarState
import com.navigation.destinations.screen.destinations.ScreenCDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun HomeB(
    navigator: DestinationsNavigator,
    topBarState: TopBarState,
    bottomBarState: BottomBarState
) {
    topBarState.updateTopBar(
        title = "Home B",
        showNavigationIcon = false
    )
    bottomBarState.updateBottomBar(isVisible = true)

    Column {
        Text(text = "Home B")
        Button(onClick = { navigator.navigate(ScreenCDestination(id = 1, name = "John")) }) {
            Text(text = "Screen C - With name")
        }
        Button(onClick = { navigator.navigate(ScreenCDestination(id = 2, name = null, isUser = false)) }) {
            Text(text = "Screen C - Without name")
        }
    }
}