package com.matttbates.screen_game

import com.matttbates.screen_game.store.GameState
import com.matttbates.screen_game.store.GameAction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matttbates.redux.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val store: Store<GameState, GameAction>
) : ViewModel() {

    val state = store.state

    init {
        startGame()
    }

    fun startGame() {
        viewModelScope.launch {
            store.dispatch(GameAction.StartGame)
        }
    }

    fun makeMove(row: Int, col: Int) {
        viewModelScope.launch {
            store.dispatch(GameAction.MakeMove(row, col))
        }
    }

}