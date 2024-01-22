package com.matttbates.redux

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Store<S: State, A: Action>(
    initialState: S,
    private val reducer: Reducer<S, A>,
    private val middlewares: List<Middleware<S, A>> = emptyList()
) {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state

    suspend fun dispatch(action: A){
        val currentState = _state.value

        val newState = reducer.reduce(currentState, action)
        _state.value = newState

        middlewares.forEach { middleware ->
            try {
                middleware.process(action, currentState, this)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}