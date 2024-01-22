package com.matttbates.screen_game

import com.matttbates.redux.Store
import com.matttbates.screen_game.store.GameAction
import com.matttbates.screen_game.store.GameReducer
import com.matttbates.screen_game.store.GameState
import com.matttbates.screen_game.store.middleware.GameMiddleware
import com.matttbates.tic_tac_toe.Game
import com.matttbates.tic_tac_toe.CellState
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GameStoreUnitTest {

    private lateinit var store: Store<GameState, GameAction>

    @Before
    fun setUp() {
        store = Store(
            initialState = GameState(),
            reducer = GameReducer(),
            middlewares = listOf(
                GameMiddleware(Game())
            )
        )
    }

    @Test
    fun `initial state is correct`() {
        val initialState = store.state.value
        val expectedState = GameState()
        assertEquals(expectedState, initialState)
    }

    @Test
    fun `start game`() = runTest {
        store.dispatch(GameAction.StartGame)
        val state = store.state.value
        val expectedState = GameState(
            currentPlayer = "X turn",
            board = arrayOf(
                arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
                arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
                arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY)
            )
        )
        assertEquals(expectedState, state)
    }

    @Test
    fun `make move`() = runTest {
        store.dispatch(GameAction.StartGame)
        store.dispatch(GameAction.MakeMove(0, 0))
        val state = store.state.value
        val expectedState = GameState(
            currentPlayer = "O turn",
            board = arrayOf(
                arrayOf(CellState.X, CellState.EMPTY, CellState.EMPTY),
                arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
                arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY)
            )
        )
        assertEquals(expectedState, state)
    }

    @Test
    fun `set current player`() = runTest {
        store.dispatch(GameAction.SetCurrentPlayer(CellState.X))
        val state = store.state.value
        val expectedState = GameState(
            currentPlayer = "X turn"
        )
        assertEquals(expectedState, state)
    }

    @Test
    fun `set winner X`() = runTest {
        store.dispatch(GameAction.SetWinner(CellState.X))
        val state = store.state.value
        val expectedState = GameState(
            winner = "X wins!"
        )
        assertEquals(expectedState, state)
    }

    @Test
    fun `set winner O`() = runTest {
        store.dispatch(GameAction.SetWinner(CellState.O))
        val state = store.state.value
        val expectedState = GameState(
            winner = "O wins!"
        )
        assertEquals(expectedState, state)
    }

    @Test
    fun `set winner TIE`() = runTest {
        store.dispatch(GameAction.SetWinner(CellState.TIE))
        val state = store.state.value
        val expectedState = GameState(
            winner = "Tie!"
        )
        assertEquals(expectedState, state)
    }

    @Test
    fun `set board`() = runTest {
        val board = arrayOf(
            arrayOf(CellState.X, CellState.EMPTY, CellState.EMPTY),
            arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
            arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY)
        )
        store.dispatch(GameAction.SetBoard(board))
        val state = store.state.value
        val expectedState = GameState(
            board = board
        )
        assertEquals(expectedState, state)
    }
}