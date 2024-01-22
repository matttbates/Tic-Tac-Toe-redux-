package com.matttbates.screen_game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun GameRoute(
    viewModel: GameViewModel,
) {

    val state by viewModel.state.collectAsState()

    GameScreen(
        state = state,
        startGame = viewModel::startGame,
        makeMove = viewModel::makeMove,
    )

}