package com.matttbates.screen_game.store

import com.matttbates.redux.Action
import com.matttbates.tic_tac_toe.Player

sealed class GameAction : Action {
    data object StartGame : GameAction()
    data class MakeMove(val row: Int, val col: Int) : GameAction()
    data class SetCurrentPlayer(val player: Player) : GameAction()
    data class SetWinner(val player: Player) : GameAction()
    data class SetBoard(val board: Array<Array<Player>>) : GameAction()
    data object Buzz : GameAction()
}