package com.matttbates.screen_game

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.matttbates.screen_game.store.GameState
import com.matttbates.tic_tac_toe.CellState

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class GameInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun showCurrentPlayerMessage() {
        composeTestRule.setContent {
            GameScreen(
                state = GameState(
                    currentPlayer = "X turn"
                ),
            )
        }
        composeTestRule.onNodeWithContentDescription("Message").assertTextEquals("X turn")
    }

    @Test
    fun showWinnerMessage() {
        composeTestRule.setContent {
            GameScreen(
                state = GameState(
                    winner = "X wins!"
                ),
            )
        }
        composeTestRule.onNodeWithContentDescription("Message").assertTextEquals("X wins!")
    }

    @Test
    fun boardIsCorrect() {
        composeTestRule.setContent {
            GameScreen(
                state = GameState(
                    board = arrayOf(
                        arrayOf(CellState.X, CellState.O, CellState.EMPTY),
                        arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
                        arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
                    )
                ),
            )
        }
        composeTestRule.onNodeWithContentDescription("Cell 0 0").assertTextEquals("X")
        composeTestRule.onNodeWithContentDescription("Cell 0 1").assertTextEquals("O")
        composeTestRule.onNodeWithContentDescription("Cell 0 2").assertTextEquals("")
        composeTestRule.onNodeWithContentDescription("Cell 1 0").assertTextEquals("")
        composeTestRule.onNodeWithContentDescription("Cell 1 1").assertTextEquals("")
        composeTestRule.onNodeWithContentDescription("Cell 1 2").assertTextEquals("")
        composeTestRule.onNodeWithContentDescription("Cell 2 0").assertTextEquals("")
        composeTestRule.onNodeWithContentDescription("Cell 2 1").assertTextEquals("")
        composeTestRule.onNodeWithContentDescription("Cell 2 2").assertTextEquals("")
    }
}