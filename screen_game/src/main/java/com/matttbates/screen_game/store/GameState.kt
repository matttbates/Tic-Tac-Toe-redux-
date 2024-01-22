package com.matttbates.screen_game.store

import com.matttbates.redux.State
import com.matttbates.tic_tac_toe.Player

data class GameState(
    val currentPlayer: String = "",
    val board: Array<Array<Player>> = arrayOf(),
    val winner: String? = null,
) : State
