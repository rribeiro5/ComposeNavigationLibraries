package com.navigation.decompose.screen.screena

import androidx.compose.runtime.State
import com.arkivanov.decompose.ComponentContext

class ScreenAComponent(
    componentContext: ComponentContext,
    val screenBResult: State<String?>,
    private val navigateToScreenB: () -> Unit
) : ComponentContext by componentContext {

    fun goToScreenB() {
        navigateToScreenB()
    }
}