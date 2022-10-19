package com.example.counter_mvi.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class MviViewModel<E : UiIntent, S : UiState>(initialState: S) : ViewModel() {

    /**
     *  same as LiveData
     *  Flow Operators (map, filter, ....)
     */
    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<S> = _uiState

    /**
     * Can Have multiple Observers
     */
    private val _uiIntent = MutableSharedFlow<E>()

    init {
        startCollectingUiIntents()
    }

    protected open fun onUiIntent(intent: E) {
        // can be overridden by children implementations
    }

    // Send an Intent from View to ViewModel
    fun sendIntent(intent: E) {
        viewModelScope.launch {
            _uiIntent.emit(intent)
        }
    }

    protected fun publishState(transformation: S.() -> S) {
        _uiState.value = transformation(_uiState.value)
    }

    // Launching a Coroutine and start to emit data
    private fun startCollectingUiIntents() {
        viewModelScope.launch {
            _uiIntent.collect { intent ->
                onUiIntent(intent)
            }
        }
    }
}
