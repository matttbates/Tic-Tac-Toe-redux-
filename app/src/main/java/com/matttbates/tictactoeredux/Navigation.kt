package com.matttbates.tictactoeredux

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.matttbates.screen_game.GameDestination
import com.matttbates.screen_game.GameRoute

@Composable
fun Navigation(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = GameDestination.route){
        composable(GameDestination.route){
            GameRoute(
                viewModel = hiltViewModel(),
            )
        }
    }
}