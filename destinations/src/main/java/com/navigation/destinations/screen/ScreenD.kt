package com.navigation.destinations.screen

import android.os.Parcelable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.navigation.destinations.component.bottombar.BottomBarState
import com.navigation.destinations.component.topbar.TopBarState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navargs.DestinationsNavTypeSerializer
import com.ramcosta.composedestinations.navargs.NavTypeSerializer
import kotlinx.parcelize.Parcelize

@Destination
@Composable
fun ScreenD(
    user: User, // Complex argument (with Parcelable)
    authState: AuthState = AuthState.GUEST, // Enum argument
    boxColor: Color, // Custom type argument (serializer at the end of the file)
    topBarState: TopBarState,
    bottomBarState: BottomBarState
) {
    topBarState.updateTopBar(title = "Screen D")
    bottomBarState.updateBottomBar(isVisible = false)

    Column {
        Text(text = "Screen D - Complex arguments")
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Authentication state: ${authState.name}")
        Text(text = "User: $user")
        Spacer(modifier = Modifier.height(15.dp))
        Box(modifier = Modifier.size(100.dp).background(boxColor))
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

// Serializer for custom type argument, other than the built-in supported arguments
@NavTypeSerializer
class ColorTypeSerializer : DestinationsNavTypeSerializer<Color> {
    override fun toRouteString(value: Color): String =
        value.toArgb().toString()

    override fun fromRouteString(routeStr: String): Color =
        Color(routeStr.toInt())
}
