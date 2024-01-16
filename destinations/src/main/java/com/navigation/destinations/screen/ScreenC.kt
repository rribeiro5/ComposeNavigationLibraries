package com.navigation.destinations.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.navigation.destinations.component.bottombar.BottomBarState
import com.navigation.destinations.component.topbar.TopBarState
import com.ramcosta.composedestinations.annotation.DeepLink
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.FULL_ROUTE_PLACEHOLDER

@Destination(
    route = "screen-c",
    deepLinks = [DeepLink(uriPattern = "https://www.navigation.com/$FULL_ROUTE_PLACEHOLDER")]
)
@Composable
fun ScreenC(
    id: Int, // Mandatory argument
    name: String?, // Optional argument
    isUser: Boolean = true, // Optional argument with default value
    topBarState: TopBarState,
    bottomBarState: BottomBarState
) {
    topBarState.updateTopBar(title = "Screen C - Primitive arguments")
    bottomBarState.updateBottomBar(isVisible = false)

    Column {
        Text(text = "Screen C")
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "ID: $id")
        Text(text = "Name: $name")
        Text(text = "isUser: $isUser")
    }
}