package com.navigation.decompose.screen.homeb

import com.arkivanov.decompose.ComponentContext

class HomeBComponent(
    componentContext: ComponentContext,
    private val navigateToScreenC: (id: Int, name: String?, isUser: Boolean) -> Unit
) : ComponentContext by componentContext {

    fun goToScreenC(
        id: Int,
        name: String?,
        isUser: Boolean = true
    ) {
        navigateToScreenC(id, name, isUser)
    }
}