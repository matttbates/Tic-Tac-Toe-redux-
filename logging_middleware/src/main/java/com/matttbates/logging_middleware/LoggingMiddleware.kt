package com.matttbates.logging_middleware

import android.util.Log
import com.matttbates.redux.Action
import com.matttbates.redux.Middleware
import com.matttbates.redux.State
import com.matttbates.redux.Store

class LoggingMiddleware<S: State, A: Action>: Middleware<S, A> {
    override suspend fun process(action: A, currentState: S, store: Store<S, A>) {
        var actionName: String = action.toString()
        if(actionName.contains("$") && actionName.contains("@")){
            actionName = actionName.substring(actionName.indexOfLast{it == '$'}+1, actionName.indexOfFirst{it == '@'})
        }
        Log.v("LoggingMiddleware", "Processing action: $actionName; Current state: $currentState")
    }
}