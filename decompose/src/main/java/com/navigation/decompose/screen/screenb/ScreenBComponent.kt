package com.navigation.decompose.screen.screenb

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class ScreenBComponent(
    componentContext: ComponentContext,
    val navigateBackWithResult: (String) -> Unit
) : ComponentContext by componentContext {

    private var _name = MutableValue("") // It can be a StateFlow or a Compose State or anything similar
    val name: Value<String> = _name

    fun updateName(name: String) {
        _name.value = name
    }

    fun navigateBack(result: String) {
        navigateBackWithResult(result)
    }
}