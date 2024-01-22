package com.matttbates.tic_tac_toe

import org.junit.Test

import org.junit.Assert.*

class BoardUnitTest {
    @Test
    fun `board setup is correct`() {
        val board = Board()
        assertEquals(false, board.checkWinner())
        assertEquals(CellState.EMPTY, board.getWinner())
        assertEquals(CellState.X, board.getTurn())
        val boardGrid = board.getBoard()
        for (row in 0 until Board.ROWS) {
            for (col in 0 until Board.COLS) {
                assertEquals(CellState.EMPTY, boardGrid[row][col])
            }
        }
    }

    @Test
    fun `board can be won by X`() {
        val board = Board()
        assertEquals(true, board.makeMove(0, 0))// X
        assertEquals(true, board.makeMove(1, 0))// O
        assertEquals(true, board.makeMove(0, 1))// X
        assertEquals(true, board.makeMove(1, 1))// O
        assertEquals(true, board.makeMove(0, 2))// X
        assertEquals(true, board.checkWinner())
        assertEquals(CellState.X, board.getWinner())
    }

    @Test
    fun `board can be won by O`() {
        val board = Board()
        assertEquals(true, board.makeMove(0, 0))// X
        assertEquals(true, board.makeMove(1, 0))// O
        assertEquals(true, board.makeMove(0, 1))// X
        assertEquals(true, board.makeMove(1, 1))// O
        assertEquals(true, board.makeMove(2, 2))// X
        assertEquals(true, board.makeMove(1, 2))// O
        assertEquals(true, board.checkWinner())
        assertEquals(CellState.O, board.getWinner())
    }

    @Test
    fun `board can be won by X on a diagonal`() {
        val board = Board()
        assertEquals(true, board.makeMove(0, 0))// X
        assertEquals(true, board.makeMove(1, 0))// O
        assertEquals(true, board.makeMove(1, 1))// X
        assertEquals(true, board.makeMove(1, 2))// O
        assertEquals(true, board.makeMove(2, 2))// X
        assertEquals(true, board.checkWinner())
        assertEquals(CellState.X, board.getWinner())
    }

    @Test
    fun `board can be won by O on a diagonal`() {
        val board = Board()
        assertEquals(true, board.makeMove(2, 0))// X
        assertEquals(true, board.makeMove(0, 0))// O
        assertEquals(true, board.makeMove(0, 1))// X
        assertEquals(true, board.makeMove(1, 1))// O
        assertEquals(true, board.makeMove(1, 2))// X
        assertEquals(true, board.makeMove(2, 2))// O
        assertEquals(true, board.checkWinner())
        assertEquals(CellState.O, board.getWinner())
    }

    @Test
    fun `board can be won by X on a column`() {
        val board = Board()
        assertEquals(true, board.makeMove(0, 0))// X
        assertEquals(true, board.makeMove(0, 1))// O
        assertEquals(true, board.makeMove(1, 0))// X
        assertEquals(true, board.makeMove(1, 1))// O
        assertEquals(true, board.makeMove(2, 0))// X
        assertEquals(true, board.checkWinner())
        assertEquals(CellState.X, board.getWinner())
    }

    @Test
    fun `board can be won by O on a column`() {
        val board = Board()
        assertEquals(true, board.makeMove(0, 0))// X
        assertEquals(true, board.makeMove(0, 1))// O
        assertEquals(true, board.makeMove(1, 0))// X
        assertEquals(true, board.makeMove(1, 1))// O
        assertEquals(true, board.makeMove(0, 2))// X
        assertEquals(true, board.makeMove(2, 1))// O
        assertEquals(true, board.checkWinner())
        assertEquals(CellState.O, board.getWinner())
    }

    @Test
    fun `board cannot be modified after a player wins`(){
        val board = Board()
        assertEquals(true, board.makeMove(0, 0))// X
        assertEquals(true, board.makeMove(0, 1))// O
        assertEquals(true, board.makeMove(1, 0))// X
        assertEquals(true, board.makeMove(1, 1))// O
        assertEquals(true, board.makeMove(2, 0))// X
        assertEquals(true, board.checkWinner())
        assertEquals(CellState.X, board.getWinner())
        assertEquals(false, board.makeMove(2, 1))// O
        assertEquals(false, board.makeMove(2, 0))// O
        assertEquals(false, board.makeMove(1, 2))// O
        assertEquals(false, board.makeMove(0, 2))// O
    }
}