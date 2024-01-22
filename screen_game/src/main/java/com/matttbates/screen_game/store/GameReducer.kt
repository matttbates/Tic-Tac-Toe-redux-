package com.matttbates.screen_game.store

import com.matttbates.redux.Reducer
import com.matttbates.tic_tac_toe.CellState

class GameReducer : Reducer<GameState, GameAction> {
    override fun reduce(
        currentState: GameState,
        action: GameAction
    ): GameState {
        return when (action) {
            is GameAction.StartGame -> {
                currentState.copy(
                    winner = null,
                )
            }
            is GameAction.SetCurrentPlayer -> {
                currentState.copy(
                    currentPlayer = "${action.player} turn"
                )
            }
            is GameAction.SetBoard -> {
                currentState.copy(
                    board = action.board
                )
            }
            is GameAction.SetWinner -> {
                currentState.copy(
                    winner = when (action.player) {
                        CellState.X -> "X wins!"
                        CellState.O -> "O wins!"
                        CellState.TIE -> "Tie!"
                        CellState.EMPTY -> null
                    }
                )
            }
            else -> currentState
        }
    }
}