package com.navigation.voyager.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.navigation.voyager.component.bottombar.LocalBottomBarState
import com.navigation.voyager.component.topbar.LocalTopBarState

data class ScreenC(
    val id: Int,
    val name: String?,
    val isUser: Boolean = true
) : Screen {

    @Composable
    override fun Content() {
        val topBarState = LocalTopBarState.current
        val bottomBarState = LocalBottomBarState.current

        LaunchedEffect(Unit) {
            topBarState.updateTopBar(title = "Screen C - Primitive arguments")
            bottomBarState.updateBottomBar(isVisible = false)
        }

        Column {
            Text(text = "Screen C")
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "ID: $id")
            Text(text = "Name: $name")
            Text(text = "isUser: $isUser")
        }
    }
}
