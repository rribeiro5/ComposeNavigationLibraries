package com.navigation.voyager.component.topbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.navigation.voyager.R

val LocalTopBarState = compositionLocalOf { TopBarState(title = "", showNavigationIcon = false) }

@Composable
fun rememberTopBarState(
    title: String = stringResource(id = R.string.app_name),
    showNavigationIcon: Boolean = false
): TopBarState = rememberSaveable(saver = TopBarState.Saver) {
    TopBarState(
        title = title,
        showNavigationIcon = showNavigationIcon
    )
}

class TopBarState(
    title: String,
    showNavigationIcon: Boolean
) {

    var title by mutableStateOf(title)
        private set

    var showNavigationIcon by mutableStateOf(showNavigationIcon)
        private set

    fun updateTopBar(
        title: String,
        showNavigationIcon: Boolean = true
    ) {
        this.title = title
        this.showNavigationIcon = showNavigationIcon
    }

    companion object {
        val Saver = listSaver<TopBarState, Any>(
            save = { listOf(it.title, it.showNavigationIcon) },
            restore = { TopBarState(it[0] as String, it[1] as Boolean) }
        )
    }
}