package com.navigation.voyager.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.navigation.voyager.component.bottombar.LocalBottomBarState
import com.navigation.voyager.component.topbar.LocalTopBarState

object HomeB : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val topBarState = LocalTopBarState.current
        val bottomBarState = LocalBottomBarState.current

        LaunchedEffect(Unit) {
            topBarState.updateTopBar(
                title = "Home B",
                showNavigationIcon = false
            )
            bottomBarState.updateBottomBar(isVisible = true)
        }

        Column {
            Text(text = "Home B")
            Button(onClick = { navigator push ScreenC(id = 1, name = "John") }) {
                Text(text = "Screen C - With name")
            }
            Button(onClick = { navigator push ScreenC(id = 2, name = null, isUser = false) }) {
                Text(text = "Screen C - Without name")
            }
        }
    }
}