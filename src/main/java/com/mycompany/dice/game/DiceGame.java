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

/**
 * Dice Game
 *
 * @author colin
 */
public final class DiceGame {

    private static final Logger logger = LoggerFactory.getLogger(DiceGame.class);

    public static final int NUMBER_OF_ROUNDS = 6;

    private GameState gameState;

    /**
     * Constructor
     *
     * @param gameState the state of the game being initialized to
     */
    public DiceGame(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * Changes the game state
     *
     * @param gameState the new state of the game
     */
    public void setState(GameState gameState) {
        this.gameState = gameState;
    }


    /**
     * Starts the game
     */
    public void startGame() {
        logger.info("Starting Dice game");

        gameState.play(this);

        Dice dice = new Dice();
        logger.trace("Initialised Dice object {}", dice);


        Player player1 = new Player(dice, "Joe", "Jane");
        Player player2 = new Player(dice, "Jane", "Joe");

        logger.trace("Initialised Player 1 {}", player1);
        logger.trace("Initialised Player 2 {}", player2);

        dice.setWhoStarts(player1.getCurrentPlayer()); //let's make player 1 start the game

        new Thread(player1).start();
        new Thread(player2).start();

        logger.trace("Started player1 thread");
        logger.trace("Started player2 thread");
    }

    /**
     * Main program
     *
     * @param args
     */
    public static void main(String[] args) {
        DiceGame diceGame = new DiceGame(new StartedState());
        diceGame.startGame();
    }
}
