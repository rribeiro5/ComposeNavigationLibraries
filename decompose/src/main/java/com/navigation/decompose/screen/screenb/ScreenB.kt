package com.navigation.decompose.screen.screenb

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.navigation.decompose.bottombar.BottomBarState
import com.navigation.decompose.topbar.TopBarState

@Composable
fun ScreenB(
    component: ScreenBComponent,
    topBarState: TopBarState,
    bottomBarState: BottomBarState
) {
    LaunchedEffect(Unit) {
        topBarState.updateTopBar(title = "Screen B")
        bottomBarState.updateBottomBar(isVisible = false)
    }

    val name by component.name.subscribeAsState()

    Column {
        Text(text = "Screen B")

        TextField(value = name, onValueChange = { component.updateName(it) })
        Button(onClick = { component.navigateBack(result = name) }) {
            Text(text = "Return name to Screen A")
        }
    }
}