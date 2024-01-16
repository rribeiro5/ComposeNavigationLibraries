package com.navigation.destinations.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.navigation.destinations.component.bottombar.BottomBarState
import com.navigation.destinations.component.topbar.TopBarState
import com.navigation.destinations.screen.destinations.BottomSheetScreenDestination
import com.navigation.destinations.screen.destinations.ScreenADestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeA(
    navigator: DestinationsNavigator,
    topBarState: TopBarState,
    bottomBarState: BottomBarState
) {
    topBarState.updateTopBar(
        title = "Home A",
        showNavigationIcon = false
    )
    bottomBarState.updateBottomBar(isVisible = true)

    Column {
        Text(text = "Home A")
        Button(onClick = { navigator.navigate(ScreenADestination()) }) {
            Text(text = "Go to Screen A")
        }
        Button(onClick = { navigator.navigate(BottomSheetScreenDestination()) }) {
            Text(text = "Open bottom sheet")
        }
    }
}