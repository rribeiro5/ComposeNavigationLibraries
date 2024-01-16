package com.navigation.destinations.component.bottombar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun rememberBottomBarState(
    isVisible: Boolean = true
): BottomBarState = rememberSaveable(saver = BottomBarState.Saver) {
    BottomBarState(isVisible = isVisible)
}

class BottomBarState(isVisible: Boolean) {

    var isVisible by mutableStateOf(isVisible)
        private set

    fun updateBottomBar(isVisible: Boolean) {
        this.isVisible = isVisible
    }

    companion object {
        val Saver = listSaver<BottomBarState, Any>(
            save = { listOf(it.isVisible) },
            restore = { BottomBarState(it[0] as Boolean) }
        )
    }
}