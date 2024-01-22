package com.matttbates.screen_game.store

import com.matttbates.redux.Action
import com.matttbates.tic_tac_toe.CellState

sealed class GameAction : Action {
    data object StartGame : GameAction()
    data class MakeMove(val row: Int, val col: Int) : GameAction()
    data class SetCurrentPlayer(val player: CellState) : GameAction()
    data class SetWinner(val player: CellState) : GameAction()
    data class SetBoard(val board: Array<Array<CellState>>) : GameAction()
    data object Buzz : GameAction()
}