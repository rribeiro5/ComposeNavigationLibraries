package com.navigation.destinations.component.topbar

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.navigation.destinations.component.topbar.TopBarState

@Composable
fun TopBar(
    state: TopBarState,
    onNavigationClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val navigationIcon: @Composable (() -> Unit)? = if (state.showNavigationIcon) {
        {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }
        }
    } else {
        null
    }

    TopAppBar(
        title = { Text(text = state.title) },
        navigationIcon = navigationIcon,
        modifier = modifier
    )
}