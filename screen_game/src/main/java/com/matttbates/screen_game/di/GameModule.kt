package com.matttbates.screen_game.di

import com.matttbates.screen_game.store.GameState
import com.matttbates.screen_game.store.GameAction
import com.matttbates.screen_game.store.GameReducer
import com.matttbates.screen_game.store.middleware.GameMiddleware
import com.matttbates.logging_middleware.LoggingMiddleware
import com.matttbates.redux.Store
import com.matttbates.screen_game.store.middleware.FeedbackMiddleware
import com.matttbates.tic_tac_toe.Game
import com.matttbates.tic_tac_toe.GameService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class GameModule {

    @Provides
    fun provideGameService(): GameService {
        return Game()
    }

    @Provides
    fun provideGameStore(
        gameMiddleware: GameMiddleware,
        feedbackMiddleware: FeedbackMiddleware
    ): Store<GameState, GameAction> {
        return Store(
            initialState = GameState(),
            reducer = GameReducer(),
            middlewares = listOf(
                LoggingMiddleware(),
                gameMiddleware,
                feedbackMiddleware
            )
        )
    }

}