package com.navigation.decompose.screen.homec

import com.arkivanov.decompose.ComponentContext
import com.navigation.decompose.screen.screend.AuthState
import com.navigation.decompose.screen.screend.User

class HomeCComponent(
    componentContext: ComponentContext,
    private val navigateToScreenD: (user: User, authState: AuthState) -> Unit
) : ComponentContext by componentContext {

    fun goToScreenD(
        user: User,
        authState: AuthState = AuthState.GUEST
    ) {
        navigateToScreenD(user, authState)
    }
}