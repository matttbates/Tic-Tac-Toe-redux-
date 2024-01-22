package com.matttbates.screen_game.store

import com.matttbates.redux.State
import com.matttbates.tic_tac_toe.CellState

data class GameState(
    val currentPlayer: String = "",
    val board: Array<Array<CellState>> = arrayOf(),
    val winner: String? = null,
) : State {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameState

        if (currentPlayer != other.currentPlayer) return false
        if (!board.contentDeepEquals(other.board)) return false
        if (winner != other.winner) return false

        return true
    }

    override fun hashCode(): Int {
        var result = currentPlayer.hashCode()
        result = 31 * result + board.contentDeepHashCode()
        result = 31 * result + (winner?.hashCode() ?: 0)
        return result
    }
}
