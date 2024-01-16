package com.navigation.destinations.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.navigation.destinations.component.bottombar.BottomBarState
import com.navigation.destinations.component.topbar.TopBarState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.result.ResultBackNavigator

@Destination
@Composable
fun ScreenB(
    resultNavigator: ResultBackNavigator<String>,
    topBarState: TopBarState,
    bottomBarState: BottomBarState
) {
    topBarState.updateTopBar(title = "Screen B")
    bottomBarState.updateBottomBar(isVisible = false)

    var name by remember { mutableStateOf("") }

    Column {
        Text(text = "Screen B")

        TextField(value = name, onValueChange = { name = it })
        Button(onClick = { resultNavigator.navigateBack(result = name) }) {
            Text(text = "Return name to Screen A")
        }
    }
}