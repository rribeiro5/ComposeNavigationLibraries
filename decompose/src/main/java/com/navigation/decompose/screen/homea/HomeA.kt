package com.navigation.decompose.screen.homea

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.navigation.decompose.bottombar.BottomBarState
import com.navigation.decompose.topbar.TopBarState

@Composable
fun HomeA(
    component: HomeAComponent,
    topBarState: TopBarState,
    bottomBarState: BottomBarState
) {
    LaunchedEffect(Unit) {
        topBarState.updateTopBar(
            title = "Home A",
            showNavigationIcon = false
        )
        bottomBarState.updateBottomBar(isVisible = true)
    }

    Column {
        Text(text = "Home A")
        Button(onClick = { component.goToScreenA() }) {
            Text(text = "Go to Screen A")
        }
    }
}