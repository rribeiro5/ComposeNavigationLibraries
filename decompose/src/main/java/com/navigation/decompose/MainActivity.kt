package com.navigation.decompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.navigation.decompose.bottombar.BottomBar
import com.navigation.decompose.bottombar.rememberBottomBarState
import com.navigation.decompose.screen.homea.HomeA
import com.navigation.decompose.screen.homeb.HomeB
import com.navigation.decompose.screen.homec.HomeC
import com.navigation.decompose.screen.screena.ScreenA
import com.navigation.decompose.screen.screenb.ScreenB
import com.navigation.decompose.screen.screenc.ScreenC
import com.navigation.decompose.screen.screend.ScreenD
import com.navigation.decompose.topbar.TopBar
import com.navigation.decompose.topbar.rememberTopBarState
import com.navigation.decompose.ui.theme.NavigationPOCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = RootComponent(defaultComponentContext())

        setContent {
            val childStack by root.childStack.subscribeAsState()
            val topBarState = rememberTopBarState()
            val bottomBarState = rememberBottomBarState()

            NavigationPOCTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopBar(
                            state = topBarState,
                            onNavigationClick = { root.navigateBack() }
                        )
                    },
                    bottomBar = {
                        if (bottomBarState.isVisible) {
                            BottomBar(
                                selectedScreen = childStack.active.instance,
                                navigateLaterally = root::navigateLaterally
                            )
                        }
                    }
                ) {
                    Children(
                        stack = childStack,
                        animation = stackAnimation(fade())
                    ) {
                        when (val child = it.instance) {
                            is RootComponent.Child.HomeA -> HomeA(
                                component = child.component,
                                topBarState = topBarState,
                                bottomBarState = bottomBarState
                            )
                            is RootComponent.Child.HomeB -> HomeB(
                                component = child.component,
                                topBarState = topBarState,
                                bottomBarState = bottomBarState
                            )
                            is RootComponent.Child.HomeC -> HomeC(
                                component = child.component,
                                topBarState = topBarState,
                                bottomBarState = bottomBarState
                            )
                            is RootComponent.Child.ScreenA -> ScreenA(
                                component = child.component,
                                topBarState = topBarState,
                                bottomBarState = bottomBarState
                            )
                            is RootComponent.Child.ScreenB -> ScreenB(
                                component = child.component,
                                topBarState = topBarState,
                                bottomBarState = bottomBarState
                            )
                            is RootComponent.Child.ScreenC -> ScreenC(
                                component = child.component,
                                topBarState = topBarState,
                                bottomBarState = bottomBarState
                            )
                            is RootComponent.Child.ScreenD -> ScreenD(
                                component = child.component,
                                topBarState = topBarState,
                                bottomBarState = bottomBarState
                            )
                        }
                    }
                }
            }
        }
    }
}