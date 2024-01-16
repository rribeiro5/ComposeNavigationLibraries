package com.navigation.decompose

import android.os.Parcelable
import androidx.compose.runtime.mutableStateOf
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.pushNew
import com.navigation.decompose.screen.homea.HomeAComponent
import com.navigation.decompose.screen.homeb.HomeBComponent
import com.navigation.decompose.screen.homec.HomeCComponent
import com.navigation.decompose.screen.screena.ScreenAComponent
import com.navigation.decompose.screen.screenb.ScreenBComponent
import com.navigation.decompose.screen.screenc.ScreenCComponent
import com.navigation.decompose.screen.screend.AuthState
import com.navigation.decompose.screen.screend.ScreenDComponent
import com.navigation.decompose.screen.screend.User
import kotlinx.parcelize.Parcelize

class RootComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()
    val childStack = childStack(
        source = navigation,
        initialConfiguration = Config.Home.HomeA,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private val screenBResult = mutableStateOf<String?>(null) // It can be a StateFlow, Value or anything similar

    fun navigateBack() {
        navigation.pop()
    }

    @OptIn(ExperimentalDecomposeApi::class)
    fun navigateLaterally(screen: Config.Home) {
        navigation.popTo(0)
        navigation.pushNew(screen)
    }

    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Config,
        context: ComponentContext
    ): Child {
        return when (config) {
            Config.Home.HomeA -> Child.HomeA(
                HomeAComponent(
                    componentContext = context,
                    navigateToScreenA = { navigation.pushNew(Config.ScreenA) }
                )
            )
            Config.Home.HomeB -> Child.HomeB(
                HomeBComponent(
                    componentContext = context,
                    navigateToScreenC = { id, name, isUser -> navigation.pushNew(Config.ScreenC(id, name, isUser)) }
                )
            )
            Config.Home.HomeC -> Child.HomeC(
                HomeCComponent(
                    componentContext = context,
                    navigateToScreenD = { user, authState -> navigation.pushNew(Config.ScreenD(user, authState)) }
                )
            )
            Config.ScreenA -> Child.ScreenA(
                ScreenAComponent(
                    componentContext = context,
                    navigateToScreenB = {
                        screenBResult.value = null
                        navigation.pushNew(Config.ScreenB)
                    },
                    screenBResult = screenBResult
                )
            )
            Config.ScreenB -> Child.ScreenB(
                ScreenBComponent(
                    componentContext = context,
                    navigateBackWithResult = {
                        screenBResult.value = it
                        navigation.pop()
                    }
                )
            )
            is Config.ScreenC -> Child.ScreenC(
                ScreenCComponent(
                    componentContext = context,
                    id = config.id,
                    name = config.name,
                    isUser = config.isUser
                )
            )
            is Config.ScreenD -> Child.ScreenD(
                ScreenDComponent(
                    componentContext = context,
                    user = config.user,
                    authState = config.authState
                )
            )
        }
    }

    sealed class Child {
        data class HomeA(val component: HomeAComponent) : Child()
        data class HomeB(val component: HomeBComponent) : Child()
        data class HomeC(val component: HomeCComponent) : Child()
        data class ScreenA(val component: ScreenAComponent) : Child()
        data class ScreenB(val component: ScreenBComponent) : Child()
        data class ScreenC(val component: ScreenCComponent) : Child()
        data class ScreenD(val component: ScreenDComponent) : Child()
    }

    sealed class Config : Parcelable {

        sealed class Home : Config() {

            @Parcelize
            data object HomeA : Home()

            @Parcelize
            data object HomeB : Home()

            @Parcelize
            data object HomeC : Home()
        }

        @Parcelize
        data object ScreenA : Config()

        @Parcelize
        data object ScreenB : Config()

        @Parcelize
        data class ScreenC(
            val id: Int,
            val name: String?,
            val isUser: Boolean = true
        ) : Config()

        @Parcelize
        data class ScreenD(
            val user: User,
            val authState: AuthState = AuthState.GUEST
        ) : Config()
    }
}