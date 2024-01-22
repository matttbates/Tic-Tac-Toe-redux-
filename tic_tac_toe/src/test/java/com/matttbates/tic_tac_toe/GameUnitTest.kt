package com.matttbates.tic_tac_toe

import org.junit.Test

import org.junit.Assert.*

class GameUnitTest {
    @Test
    fun `board setup is correct`() {
        val game = Game()
        val expectedBoard = arrayOf(
            arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
            arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
            arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY)
        )
        assertArrayEquals(expectedBoard, game.getBoard())
    }

    @Test
    fun `first move is X`() {
        val game = Game()
        assertEquals(CellState.X, game.getTurn())
    }

    @Test
    fun `second move is O`() {
        val game = Game()
        game.makeMove(0, 0)
        assertEquals(CellState.O, game.getTurn())
    }

    @Test
    fun `reset game`() {
        val game = Game()
        game.makeMove(0, 0)
        game.startGame()
        assertEquals(CellState.X, game.getTurn())
        val expectedBoard = arrayOf(
            arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
            arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY),
            arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.EMPTY)
        )
        assertArrayEquals(expectedBoard, game.getBoard())
    }
}