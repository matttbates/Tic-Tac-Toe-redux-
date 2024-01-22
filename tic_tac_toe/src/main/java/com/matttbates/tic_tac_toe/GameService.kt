package com.matttbates.tic_tac_toe

interface GameService {
    fun startGame()
    fun makeMove(x: Int, y: Int)
    fun getBoard(): Array<Array<Player>>
    fun getTurn(): Player
    fun getWinner(): Player
}