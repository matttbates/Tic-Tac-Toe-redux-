package com.matttbates.tic_tac_toe

enum class CellState {
    X, O, EMPTY, TIE;

    override fun toString(): String {
        return when (this) {
            X -> "X"
            O -> "O"
            EMPTY -> ""
            TIE -> ""
        }
    }
}