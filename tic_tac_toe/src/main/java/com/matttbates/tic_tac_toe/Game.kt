package com.matttbates.tic_tac_toe

class Game: GameService {
    private var board = Board()
    override fun startGame() {
        board = Board()
    }

    override fun makeMove(x: Int, y: Int) {
        board.makeMove(x, y)
        board.checkWinner()
    }

    override fun getBoard(): Array<Array<Player>> {
        return board.getBoard()
    }

    override fun getTurn(): Player {
        return board.getTurn()
    }

    override fun getWinner(): Player {
        return board.getWinner()
    }

}