package com.navigation.decompose.screen.screenc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.navigation.decompose.bottombar.BottomBarState
import com.navigation.decompose.topbar.TopBarState

@Composable
fun ScreenC(
    component: ScreenCComponent,
    topBarState: TopBarState,
    bottomBarState: BottomBarState
) {
    LaunchedEffect(Unit) {
        topBarState.updateTopBar(title = "Screen C - Primitive arguments")
        bottomBarState.updateBottomBar(isVisible = false)
    }

    Column {
        Text(text = "Screen C")
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "ID: ${component.id}")
        Text(text = "Name: ${component.name}")
        Text(text = "isUser: ${component.isUser}")
    }
}