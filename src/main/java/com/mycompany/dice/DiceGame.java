/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Dice Game
 *
 * @author colin
 */
public final class DiceGame {

    private static final Logger logger = LoggerFactory.getLogger(DiceGame.class);

    static final int NUMBER_OF_ROUNDS = 6;

    /**
     * Main program
     *
     * @param args
     */
    public static void main(String[] args) {

        logger.info("Starting Dice game");

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
}
