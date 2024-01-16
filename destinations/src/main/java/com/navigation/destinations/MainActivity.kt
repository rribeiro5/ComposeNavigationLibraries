package com.navigation.destinations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.plusAssign
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.navigation.destinations.component.topbar.TopBar
import com.navigation.destinations.component.bottombar.BottomBar
import com.navigation.destinations.component.bottombar.rememberBottomBarState
import com.navigation.destinations.component.topbar.rememberTopBarState
import com.navigation.destinations.screen.NavGraphs
import com.navigation.destinations.ui.theme.NavigationPOCTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.dependency

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val bottomSheetNavigator = rememberBottomSheetNavigator()
            val topBarState = rememberTopBarState()
            val bottomBarState = rememberBottomBarState()
            navController.navigatorProvider += bottomSheetNavigator

            NavigationPOCTheme {
                ModalBottomSheetLayout(
                    bottomSheetNavigator = bottomSheetNavigator,
                    sheetShape = RoundedCornerShape(16.dp)
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            TopBar(
                                state = topBarState,
                                onNavigationClick = { navController.popBackStack() }
                            )
                        },
                        bottomBar = {
                            if (bottomBarState.isVisible) {
                                BottomBar(navController = navController)
                            }
                        }
                    ) {
                        DestinationsNavHost(
                            navGraph = NavGraphs.root,
                            navController = navController,
                            engine = rememberAnimatedNavHostEngine(
                                rootDefaultAnimations = RootNavGraphDefaultAnimations.ACCOMPANIST_FADING
                            ),
                            modifier = Modifier.fillMaxSize(),
                            dependenciesContainerBuilder = {
                                dependency(topBarState)
                                dependency(bottomBarState)
                            }
                        )
                    }
                }
            }
        }
    }
}
