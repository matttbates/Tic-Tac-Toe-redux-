package com.matttbates.tic_tac_toe

class Board {

    companion object {
        const val ROWS = 3
        const val COLS = 3
    }

    private val board: Array<Array<Player>> = Array(ROWS) { Array(COLS) { Player.NONE } }
    private var turn = Player.X
    private var winner = Player.NONE

    fun getTurn(): Player {
        return turn
    }

    fun getWinner(): Player {
        return winner
    }

    fun getBoard(): Array<Array<Player>> {
        return board
    }

    fun makeMove(row: Int, col: Int): Boolean {
        if (winner != Player.NONE) {
            return false
        }
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            return false
        }
        if (board[row][col] == Player.NONE) {
            board[row][col] = turn
            turn = if (turn == Player.X) {
                Player.O
            } else {
                Player.X
            }
            return true
        }
        return false
    }

    fun checkWinner(): Boolean{
        // check rows
        for (row in 0 until ROWS) {
            if (board[row][0] != Player.NONE && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                winner = board[row][0]
                return true
            }
        }
        // check columns
        for (col in 0 until COLS) {
            if (board[0][col] != Player.NONE && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                winner = board[0][col]
                return true
            }
        }
        // check diagonals
        if (board[0][0] != Player.NONE && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            winner = board[0][0]
            return true
        }
        if (board[0][2] != Player.NONE && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            winner = board[0][2]
            return true
        }
        // check tie
        var tie = true
        for (row in 0 until ROWS) {
            for (col in 0 until COLS) {
                if (board[row][col] == Player.NONE) {
                    tie = false
                }
            }
        }
        if (tie) {
            winner = Player.TIE
            return true
        }
        return false
    }

}