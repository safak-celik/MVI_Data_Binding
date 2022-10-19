package com.example.counter_mvi.main

import com.example.counter_mvi.base.MviViewModel
import com.example.counter_mvi.main.MainUiIntent.*

class MainViewModel : MviViewModel<MainUiIntent, MainUiState>(MainUiState()) {

    override fun onUiIntent(intent: MainUiIntent) {
        when (intent) {
            is StartClicked -> onStartClicked()
            is MinusClicked -> onMinusClicked()
            is PlusClicked -> onPlusClicked()
        }
        super.onUiIntent(intent)
    }

    /**
     * To use these functions directly with Data Binding
     * set these functions as public functions
     */
    fun onStartClicked() {
        publishState { copy(counter = counter + 1) }
    }

    fun onMinusClicked() {
        publishState { copy(counter = counter - 1) }
    }

    fun onPlusClicked() {
        publishState { copy(counter = counter + 1) }
    }
}
