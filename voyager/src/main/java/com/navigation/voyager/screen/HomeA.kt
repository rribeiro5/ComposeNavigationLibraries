package com.navigation.voyager.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.navigation.voyager.component.bottombar.LocalBottomBarState
import com.navigation.voyager.component.topbar.LocalTopBarState

object HomeA : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val bottomSheetNavigator = LocalBottomSheetNavigator.current
        val topBarState = LocalTopBarState.current
        val bottomBarState = LocalBottomBarState.current

        LaunchedEffect(Unit) {
            topBarState.updateTopBar(
                title = "Home A",
                showNavigationIcon = false
            )
            bottomBarState.updateBottomBar(isVisible = true)
        }

        Column {
            Text(text = "Home A")
            Button(onClick = { navigator push ScreenA() }) {
                Text(text = "Go to Screen A")
            }
            Button(onClick = { bottomSheetNavigator.show(BottomSheetScreen()) }) {
                Text(text = "Open bottom sheet")
            }
        }
    }
}