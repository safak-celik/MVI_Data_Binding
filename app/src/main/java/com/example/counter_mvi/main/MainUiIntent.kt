package com.example.counter_mvi.main

import com.example.counter_mvi.base.UiIntent

sealed class MainUiIntent : UiIntent {

    object StartClicked : MainUiIntent()
    object MinusClicked : MainUiIntent()
    object PlusClicked : MainUiIntent()
}
