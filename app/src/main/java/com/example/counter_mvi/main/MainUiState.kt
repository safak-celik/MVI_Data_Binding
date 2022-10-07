package com.example.counter_mvi.main

import com.example.counter_mvi.base.UiState


data class MainUiState(
    val counter: Int = 0
) : UiState {
    // region Text States
    val maxReached: Boolean get() = counter == 10
    val counterText: String get() = counter.toString()
    // end

    // region Button States
    val shouldEnableStartButton: Boolean get() = counter == 0
    val shouldEnableMinusButton: Boolean get() = counter != 0
    val shouldEnablePlusButton: Boolean get() = counter != 0 && !maxReached
    // end
}