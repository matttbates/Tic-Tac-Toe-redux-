package com.matttbates.tic_tac_toe

enum class Player {
    X, O, NONE, TIE;

    override fun toString(): String {
        return when (this) {
            X -> "X"
            O -> "O"
            NONE -> ""
            TIE -> ""
        }
    }
}