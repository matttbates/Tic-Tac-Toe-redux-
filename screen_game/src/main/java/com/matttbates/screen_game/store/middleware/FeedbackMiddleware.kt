package com.matttbates.screen_game.store.middleware

import com.matttbates.device_hardware.DeviceHardwareService
import com.matttbates.screen_game.store.GameState
import com.matttbates.screen_game.store.GameAction
import com.matttbates.redux.Middleware
import com.matttbates.redux.Store
import javax.inject.Inject

class FeedbackMiddleware @Inject constructor(
    private val deviceHardwareService: DeviceHardwareService
) : Middleware<GameState, GameAction> {
    override suspend fun process(
        action: GameAction,
        currentState: GameState,
        store: Store<GameState, GameAction>
    ) {
        when (action) {
            is GameAction.Buzz -> {
                //vibrate phone
                deviceHardwareService.vibrate()
            }
            else -> Unit
        }
    }
}