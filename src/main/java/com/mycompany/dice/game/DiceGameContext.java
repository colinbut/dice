/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice.game;

import com.mycompany.dice.model.Dice;
import com.mycompany.dice.model.Player;
import com.mycompany.dice.game.states.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Contains contextual management information associated to the game
 *
 * Is responsible for managing most game related activities
 *
 * @author colin
 */
public final class DiceGameContext {

    private static final Logger logger = LoggerFactory.getLogger(DiceGameContext.class);

    private GameState gameState;

    private List<GamePlayer> players = new ArrayList<>();

    private static Map<GameStates, GameState> gameStates = new EnumMap<>(GameStates.class);

    static {
        gameStates.put(GameStates.STARTED, StartedState.getInstance());
        gameStates.put(GameStates.PLAYING, PlayingState.getInstance());
        gameStates.put(GameStates.ENDED, EndingState.getInstance());
    }


    /**
     * Starts the game
     */
    public void playGame() {
        logger.info("Starting Dice game");

        gameState = gameStates.get(GameStates.STARTED);
        gameState.transition();

        prepareGame();

        gameState = gameStates.get(GameStates.PLAYING);
        gameState.transition();

        List<Thread> playerThreads = new ArrayList<>();
        play(playerThreads);

        // wait for this player thread to finish
        for (Thread playerThread : playerThreads) {

            try {
                playerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // when it gets here - game finished
        gameState = gameStates.get(GameStates.ENDED);
        gameState.transition();

    }


    /**
     * Starts the player threads in order to start 'playing' the
     * game
     *
     * @param playerThreads
     */
    private void play(List<Thread> playerThreads) {
        for (GamePlayer player : players) {
            Thread playerThread = new Thread(player);
            playerThread.start();

            logger.trace("Started player thread");

            playerThreads.add(playerThread);

        }
    }


    /**
     * Prepares the game variables:
     * - the Dice
     * - the players
     */
    private void prepareGame() {
        Dice dice = new Dice();
        logger.trace("Initialised Dice object {}", dice);

        Player player1 = new Player("Joe", "Jane");
        Player player2 = new Player("Jane", "Joe");

        logger.trace("Initialised Player 1 {}", player1);
        logger.trace("Initialised Player 2 {}", player2);

        dice.setWhoStarts(player1.getCurrentPlayer()); //let's make player 1 start the game

        GamePlayer gamePlayer1 = new GamePlayer(dice, player1);
        GamePlayer gamePlayer2 = new GamePlayer(dice, player2);

        players.add(gamePlayer1);
        players.add(gamePlayer2);
    }
}
