package com.navigation.voyager.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.navigation.voyager.component.bottombar.LocalBottomBarState
import com.navigation.voyager.component.topbar.LocalTopBarState

data class ScreenD(
    val user: User,
    val authState: AuthState = AuthState.GUEST,
    val boxColor: Color = Color.Transparent
) : Screen {

    @Composable
    override fun Content() {
        val topBarState = LocalTopBarState.current
        val bottomBarState = LocalBottomBarState.current

        LaunchedEffect(Unit) {
            topBarState.updateTopBar(title = "Screen D")
            bottomBarState.updateBottomBar(isVisible = false)
        }

        Column {
            Text(text = "Screen D - Complex arguments")
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Authentication state: ${authState.name}")
            Text(text = "User: $user")
            Spacer(modifier = Modifier.height(15.dp))
            Box(modifier = Modifier
                .size(100.dp)
                .background(boxColor))
        }
    }
}

enum class AuthState {
    AUTHENTICATED,
    GUEST
}

data class User(
    val id: Int,
    val name: String,
    val city: String?
)
