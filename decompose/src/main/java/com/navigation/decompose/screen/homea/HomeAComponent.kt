package com.navigation.decompose.screen.homea

import com.arkivanov.decompose.ComponentContext

class HomeAComponent(
    componentContext: ComponentContext,
    private val navigateToScreenA: () -> Unit
) : ComponentContext by componentContext {

    fun goToScreenA() {
        navigateToScreenA()
    }
}