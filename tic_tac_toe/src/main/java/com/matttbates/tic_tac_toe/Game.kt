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

    override fun getBoard(): Array<Array<CellState>> {
        return board.getBoard()
    }

    override fun getTurn(): CellState {
        return board.getTurn()
    }

    override fun getWinner(): CellState {
        return board.getWinner()
    }

}