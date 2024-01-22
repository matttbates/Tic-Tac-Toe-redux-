package com.matttbates.tic_tac_toe

interface GameService {
    fun startGame()
    fun makeMove(x: Int, y: Int)
    fun getBoard(): Array<Array<CellState>>
    fun getTurn(): CellState
    fun getWinner(): CellState
}