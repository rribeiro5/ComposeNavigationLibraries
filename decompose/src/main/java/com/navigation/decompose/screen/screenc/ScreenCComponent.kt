package com.navigation.decompose.screen.screenc

import com.arkivanov.decompose.ComponentContext

class ScreenCComponent(
    componentContext: ComponentContext,
    val id: Int,
    val name: String?,
    val isUser: Boolean = true
) : ComponentContext by componentContext {
}