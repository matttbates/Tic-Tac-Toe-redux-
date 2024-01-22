package com.matttbates.screen_game

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.matttbates.screen_game.store.GameState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matttbates.tic_tac_toe.Player

@Preview
@Composable
fun GameScreen(
    state: GameState = GameState(
        currentPlayer = "X turn",
        board = arrayOf(
            arrayOf(Player.X, Player.NONE, Player.O),
            arrayOf(Player.NONE, Player.X, Player.NONE),
            arrayOf(Player.NONE, Player.NONE, Player.X),
        ),
        winner = null,
    ),
    startGame: () -> Unit = {},
    makeMove: (Int, Int) -> Unit = { _, _ -> }
) {
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Text(
            text = state.winner?:state.currentPlayer,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 48.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
        GameBoard(
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxWidth(),
            state = state,
            makeMove = makeMove
        )
        Button(
            onClick = startGame
        ) {
            Text(text = "Restart Game")
        }
    }
}

@Preview
@Composable
fun GameBoard(
    modifier: Modifier = Modifier,
    state: GameState = GameState(),
    makeMove: (Int, Int) -> Unit = { _, _ -> }
) {
    Column(modifier = modifier
        .fillMaxSize(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        state.board.forEachIndexed { rowIndex, row ->
            Row(modifier = Modifier
                .weight(1f),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            ) {
                row.forEachIndexed { colIndex, player ->
                    Box(modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable {
                            makeMove(rowIndex, colIndex)
                        },
                        contentAlignment = androidx.compose.ui.Alignment.Center
                    ) {
                        Text(
                            text = player.toString(),
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 48.sp,
                                color = if (player == Player.O) {
                                    androidx.compose.ui.graphics.Color.Blue
                                } else {
                                    androidx.compose.ui.graphics.Color.Red
                                }
                            )
                        )
                    }
                    if (colIndex < state.board[rowIndex].size - 1) {
                        Box(modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                            .background(color = DividerDefaults.color))
                    }
                }
            }
            if (rowIndex < state.board.size - 1) {
                androidx.compose.material3.Divider()
            }
        }
    }
}