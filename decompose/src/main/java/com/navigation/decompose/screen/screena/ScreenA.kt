package com.navigation.decompose.screen.screena

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.navigation.decompose.bottombar.BottomBarState
import com.navigation.decompose.topbar.TopBarState

@Composable
fun ScreenA(
    component: ScreenAComponent,
    topBarState: TopBarState,
    bottomBarState: BottomBarState
) {
    LaunchedEffect(Unit) {
        topBarState.updateTopBar(title = "Screen A")
        bottomBarState.updateBottomBar(isVisible = false)
    }

    val name by remember { component.screenBResult }

    Column {
        Text(text = "Screen A")
        Button(onClick = { component.goToScreenB() }) {
            Text(text = "Go to Screen B")
        }
        Spacer(modifier = Modifier.height(30.dp))
        if (name != null) {
            Text(text = "Returned name: $name")
        }
    }
}