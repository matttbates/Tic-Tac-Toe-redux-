package com.matttbates.redux

interface Reducer<S: State, A: Action> {
    fun reduce(currentState: S, action: A): S
}