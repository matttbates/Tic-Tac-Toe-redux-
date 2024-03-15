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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matttbates.screen_game.store.GameState
import com.matttbates.tic_tac_toe.CellState

@Preview
@Composable
fun GameScreen(
    state: GameState = GameState(
        currentPlayer = "X turn",
        board = arrayOf(
            arrayOf(CellState.X, CellState.EMPTY, CellState.O),
            arrayOf(CellState.EMPTY, CellState.X, CellState.EMPTY),
            arrayOf(CellState.EMPTY, CellState.EMPTY, CellState.X),
        ),
        winner = null,
    ),
    startGame: () -> Unit = {},
    makeMove: (Int, Int) -> Unit = { _, _ -> }
) {
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Text(modifier = Modifier
            .semantics { contentDescription = "Message" },
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
        IconButton(modifier = Modifier
            .size(100.dp),
            onClick = startGame
        ) {
            Icon(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
                imageVector = Icons.Default.Refresh,
                contentDescription = stringResource(R.string.restart)
            )
        }
        val context = LocalContext.current
        Text(modifier = Modifier
            .padding(start = 16.dp)
            .align(Alignment.Start)
            .clickable {
                context.startActivity(
                    android.content.Intent(
                        android.content.Intent.ACTION_VIEW,
                        android.net.Uri.parse("https://matttbates.github.io/Tic-Tac-Toe-redux-/privacy_policy.html")
                    )
                )
            },
            text = "Privacy Policy",
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 24.sp,
                color = Color.Blue
            )
        )
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
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        state.board.forEachIndexed { rowIndex, row ->
            Row(modifier = Modifier
                .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                row.forEachIndexed { colIndex, player ->
                    Box(modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable {
                            makeMove(rowIndex, colIndex)
                        },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(modifier = Modifier
                            .semantics { contentDescription = "Cell $rowIndex $colIndex" },
                            text = player.toString(),
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 48.sp,
                                color = if (player == CellState.O) {
                                    Color.Blue
                                } else {
                                    Color.Red
                                }
                            )
                        )
                    }
                    if (colIndex < state.board[rowIndex].size - 1) {
                        Box(modifier = Modifier
                            .width(2.dp)
                            .fillMaxHeight()
                            .background(color = DividerDefaults.color))
                    }
                }
            }
            if (rowIndex < state.board.size - 1) {
                androidx.compose.material3.HorizontalDivider(
                    thickness = 2.dp,
                )
            }
        }
    }
}