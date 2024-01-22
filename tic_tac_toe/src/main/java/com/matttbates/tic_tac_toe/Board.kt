package com.matttbates.tic_tac_toe

class Board {

    companion object {
        const val ROWS = 3
        const val COLS = 3
    }

    private val board: Array<Array<CellState>> = Array(ROWS) { Array(COLS) { CellState.EMPTY } }
    private var turn = CellState.X
    private var winner = CellState.EMPTY

    fun getTurn(): CellState {
        return turn
    }

    fun getWinner(): CellState {
        return winner
    }

    fun getBoard(): Array<Array<CellState>> {
        return board
    }

    fun makeMove(row: Int, col: Int): Boolean {
        if (winner != CellState.EMPTY) {
            return false
        }
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            return false
        }
        if (board[row][col] == CellState.EMPTY) {
            board[row][col] = turn
            turn = if (turn == CellState.X) {
                CellState.O
            } else {
                CellState.X
            }
            return true
        }
        return false
    }

    fun checkWinner(): Boolean{
        // check rows
        for (row in 0 until ROWS) {
            if (board[row][0] != CellState.EMPTY && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                winner = board[row][0]
                return true
            }
        }
        // check columns
        for (col in 0 until COLS) {
            if (board[0][col] != CellState.EMPTY && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                winner = board[0][col]
                return true
            }
        }
        // check diagonals
        if (board[0][0] != CellState.EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            winner = board[0][0]
            return true
        }
        if (board[0][2] != CellState.EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            winner = board[0][2]
            return true
        }
        // check tie
        var tie = true
        for (row in 0 until ROWS) {
            for (col in 0 until COLS) {
                if (board[row][col] == CellState.EMPTY) {
                    tie = false
                }
            }
        }
        if (tie) {
            winner = CellState.TIE
            return true
        }
        return false
    }

}