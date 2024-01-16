package com.navigation.decompose.screen.homeb

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.navigation.decompose.bottombar.BottomBarState
import com.navigation.decompose.topbar.TopBarState

@Composable
fun HomeB(
    component: HomeBComponent,
    topBarState: TopBarState,
    bottomBarState: BottomBarState
) {
    LaunchedEffect(Unit) {
        topBarState.updateTopBar(
            title = "Home B",
            showNavigationIcon = false
        )
        bottomBarState.updateBottomBar(isVisible = true)
    }

    Column {
        Text(text = "Home B")
        Button(onClick = { component.goToScreenC(id = 1, name = "John") }) {
            Text(text = "Screen C - With name")
        }
        Button(onClick = { component.goToScreenC(id = 2, name = null, isUser = false) }) {
            Text(text = "Screen C - Without name")
        }
    }
}