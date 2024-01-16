package com.navigation.decompose.screen.screend

import com.arkivanov.decompose.ComponentContext

class ScreenDComponent(
    componentContext: ComponentContext,
    val user: User,
    val authState: AuthState = AuthState.GUEST
) : ComponentContext by componentContext {
}