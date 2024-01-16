package com.navigation.decompose.screen.screend

import android.os.Parcelable
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
import androidx.compose.ui.unit.dp
import com.navigation.decompose.bottombar.BottomBarState
import com.navigation.decompose.topbar.TopBarState
import kotlinx.parcelize.Parcelize

@Composable
fun ScreenD(
    component: ScreenDComponent,
    topBarState: TopBarState,
    bottomBarState: BottomBarState
) {
    LaunchedEffect(Unit) {
        topBarState.updateTopBar(title = "Screen D")
        bottomBarState.updateBottomBar(isVisible = false)
    }

    Column {
        Text(text = "Screen D - Complex arguments")
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Authentication state: ${component.authState.name}")
        Text(text = "User: ${component.user}")
    }
}

enum class AuthState {
    AUTHENTICATED,
    GUEST
}

@Parcelize
data class User(
    val id: Int,
    val name: String,
    val city: String?
) : Parcelable
