package com.navigation.voyager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.transitions.FadeTransition
import com.navigation.voyager.component.bottombar.BottomBar
import com.navigation.voyager.component.bottombar.LocalBottomBarState
import com.navigation.voyager.component.bottombar.rememberBottomBarState
import com.navigation.voyager.component.topbar.LocalTopBarState
import com.navigation.voyager.component.topbar.TopBar
import com.navigation.voyager.component.topbar.rememberTopBarState
import com.navigation.voyager.screen.HomeA
import com.navigation.voyager.ui.theme.NavigationPOCTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val topBarState = rememberTopBarState()
            val bottomBarState = rememberBottomBarState()

            NavigationPOCTheme {
                BottomSheetNavigator {
                    Navigator(screen = HomeA) { navigator ->
                        Scaffold(
                            topBar = { TopBar(
                                state = topBarState,
                                onNavigationClick = { navigator.pop() }
                            ) },
                            bottomBar = {
                                if (bottomBarState.isVisible) {
                                    BottomBar(navigator = navigator)
                                }
                            }
                        ) {
                            CompositionLocalProvider(
                                LocalTopBarState provides topBarState,
                                LocalBottomBarState provides bottomBarState
                            ) {
                                FadeTransition(
                                    navigator = navigator,
                                    modifier = Modifier.fillMaxSize()
                                ) { screen ->
                                    screen.Content()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
