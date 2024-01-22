package com.matttbates.screen_game.store.middleware

import com.matttbates.screen_game.store.GameState
import com.matttbates.screen_game.store.GameAction
import com.matttbates.redux.Middleware
import com.matttbates.redux.Store
import com.matttbates.tic_tac_toe.GameService
import com.matttbates.tic_tac_toe.CellState
import javax.inject.Inject

class GameMiddleware @Inject constructor(
    private val gameService: GameService
) : Middleware<GameState, GameAction> {
    override suspend fun process(
        action: GameAction,
        currentState: GameState,
        store: Store<GameState, GameAction>
    ) {
        when (action) {
            is GameAction.StartGame -> {
                gameService.startGame()
                val board = gameService.getBoard()
                store.dispatch(GameAction.SetBoard(board))
                val currentPlayer = gameService.getTurn()
                store.dispatch(GameAction.SetCurrentPlayer(currentPlayer))
            }
            is GameAction.MakeMove -> {
                gameService.makeMove(action.row, action.col)
                val board = gameService.getBoard()
                store.dispatch(GameAction.SetBoard(board))
                val currentPlayer = gameService.getTurn()
                store.dispatch(GameAction.SetCurrentPlayer(currentPlayer))
                val winner = gameService.getWinner()
                if (winner != CellState.EMPTY) {
                    store.dispatch(GameAction.SetWinner(winner))
                    store.dispatch(GameAction.Buzz)
                }
            }
            else -> Unit
        }
    }
}