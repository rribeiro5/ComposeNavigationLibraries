package com.navigation.destinations.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.navigation.destinations.component.bottombar.BottomBarState
import com.navigation.destinations.component.topbar.TopBarState
import com.navigation.destinations.screen.destinations.ScreenDDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun HomeC(
    navigator: DestinationsNavigator,
    topBarState: TopBarState,
    bottomBarState: BottomBarState
) {
    topBarState.updateTopBar(
        title = "Home C",
        showNavigationIcon = false
    )
    bottomBarState.updateBottomBar(isVisible = true)

    Column {
        Text(text = "Home C")
        Button(onClick = {
            navigator.navigate(
                ScreenDDestination(
                    authState = AuthState.AUTHENTICATED,
                    user = User(
                        id = 1,
                        name = "John",
                        city = "Porto"
                    ),
                    boxColor = Color.Transparent
                )
            )
        }) {
            Text(text = "Screen D - Authenticated user")
        }
        Button(onClick = {
            navigator.navigate(
                ScreenDDestination(
                    user = User(id = 2, name = "Jane", city = null),
                    boxColor = Color.Transparent
                )
            )
        }) {
            Text(text = "Screen D - Guest user")
        }
        Button(onClick = {
            navigator.navigate(
                ScreenDDestination(
                    user = User(id = 3, name = "John", city = null),
                    boxColor = Color.Blue
                )
            )
        }) {
            Text(text = "Screen D - Box color")
        }
    }
}