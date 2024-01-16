package com.navigation.destinations.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.navigation.destinations.component.bottombar.BottomBarState
import com.navigation.destinations.component.topbar.TopBarState
import com.navigation.destinations.screen.destinations.ScreenBDestination
import com.ramcosta.composedestinations.annotation.DeepLink
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.result.NavResult
import com.ramcosta.composedestinations.result.ResultRecipient

@Destination(
    deepLinks = [DeepLink(uriPattern = "https://www.navigation.com/screen-a")]
)
@Composable
fun ScreenA(
    navigator: DestinationsNavigator,
    screenBResult: ResultRecipient<ScreenBDestination, String>,
    topBarState: TopBarState,
    bottomBarState: BottomBarState
) {
    topBarState.updateTopBar(title = "Screen A")
    bottomBarState.updateBottomBar(isVisible = false)

    var name by remember { mutableStateOf<String?>(null) }

    screenBResult.onNavResult { result ->
        name = when (result) {
            is NavResult.Canceled -> "Name was not returned from Screen B"
            is NavResult.Value -> "Returned name: ${result.value}"
        }
    }

    Column {
        Text(text = "Screen A")
        Button(onClick = { navigator.navigate(direction = ScreenBDestination(), onlyIfResumed = true) }) {
            Text(text = "Go to Screen B")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = name.orEmpty())
    }
}