/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice.game;

import com.mycompany.dice.Dice;
import com.mycompany.dice.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Dice Game
 *
 * @author colin
 */
public final class DiceGame {

    private static final Logger logger = LoggerFactory.getLogger(DiceGame.class);

    public static final int NUMBER_OF_ROUNDS = 6;

    private static GameState gameState;

    private List<Player> players = new ArrayList<>();

    private static Map<GameStates, GameState> gameStates = new HashMap<>();

    static {
        gameStates.put(GameStates.STARTED, new StartedState());
        gameStates.put(GameStates.PLAYING, new PlayingState());
        gameStates.put(GameStates.ENDED, new EndingState());
    }



    /**
     * Changes the game state
     *
     * @param gameState the new state of the game
     */
    public static void setState(GameState gameState) {
        DiceGame.gameState = gameState;
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


    private void play(List<Thread> playerThreads) {
        for (Player player : players) {
            Thread playerThread = new Thread(player);
            playerThread.start();

            logger.trace("Started player thread");

            playerThreads.add(playerThread);

        }
    }


    private void prepareGame() {
        Dice dice = new Dice();
        logger.trace("Initialised Dice object {}", dice);

        Player player1 = new Player(dice, "Joe", "Jane");
        Player player2 = new Player(dice, "Jane", "Joe");

        logger.trace("Initialised Player 1 {}", player1);
        logger.trace("Initialised Player 2 {}", player2);

        dice.setWhoStarts(player1.getCurrentPlayer()); //let's make player 1 start the game

        players.add(player1);
        players.add(player2);
    }

    /**
     * Main program
     *
     * @param args
     */
    public static void main(String[] args) {
        DiceGame diceGame = new DiceGame();
        diceGame.playGame();
    }
}