package com.navigation.voyager.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.screen.Screen
import com.navigation.voyager.component.bottombar.LocalBottomBarState
import com.navigation.voyager.component.topbar.LocalTopBarState

class ScreenB : Screen {

    @Composable
    override fun Content() {
        val topBarState = LocalTopBarState.current
        val bottomBarState = LocalBottomBarState.current

        LaunchedEffect(Unit) {
            topBarState.updateTopBar(title = "Screen B")
            bottomBarState.updateBottomBar(isVisible = false)
        }

        Column {
            Text(text = "Screen B")
        }
    }
}