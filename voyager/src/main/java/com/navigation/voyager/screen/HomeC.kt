package com.navigation.voyager.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.navigation.voyager.component.bottombar.LocalBottomBarState
import com.navigation.voyager.component.topbar.LocalTopBarState

object HomeC : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val topBarState = LocalTopBarState.current
        val bottomBarState = LocalBottomBarState.current

        LaunchedEffect(Unit) {
            topBarState.updateTopBar(
                title = "Home C",
                showNavigationIcon = false
            )
            bottomBarState.updateBottomBar(isVisible = true)
        }

        Column {
            Text(text = "Home C")
            Button(onClick = {
                navigator.push(
                    ScreenD(
                        authState = AuthState.AUTHENTICATED,
                        user = User(
                            id = 1,
                            name = "John",
                            city = "Porto"
                        )
                    )
                )
            }) {
                Text(text = "Screen D - Authenticated user")
            }
            Button(onClick = {
                navigator.push(ScreenD(user = User(id = 2, name = "Jane", city = null)))
            }) {
                Text(text = "Screen D - Guest user")
            }
            Button(onClick = {
                navigator.push(
                    ScreenD(
                        user = User(id = 3, name = "John", city = null),
                        boxColor = Color.Blue
                    )
                )
            }) {
                Text(text = "Screen D - Box color")
            }
        }
    }
}