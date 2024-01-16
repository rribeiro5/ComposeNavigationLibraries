package com.navigation.decompose.screen.homec

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.navigation.decompose.bottombar.BottomBarState
import com.navigation.decompose.screen.screend.AuthState
import com.navigation.decompose.screen.screend.User
import com.navigation.decompose.topbar.TopBarState

@Composable
fun HomeC(
    component: HomeCComponent,
    topBarState: TopBarState,
    bottomBarState: BottomBarState
) {
    LaunchedEffect(Unit) {
        topBarState.updateTopBar(
            title = "Home C",
            showNavigationIcon = false
        )
        bottomBarState.updateBottomBar(isVisible = true)
    }

    Column {
        Text(text = "Home C")
        Button(onClick = {
            component.goToScreenD(
                authState = AuthState.AUTHENTICATED,
                user = User(
                    id = 1,
                    name = "John",
                    city = "Porto"
                )
            )
        }) {
            Text(text = "Screen D - Authenticated user")
        }
        Button(onClick = { component.goToScreenD(user = User(id = 2, name = "Jane", city = null)) }) {
            Text(text = "Screen D - Guest user")
        }
    }
}