/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Abstracting how the dice rolls and decides who plays it
 *
 * @author colin
 */
public final class Dice {

    private static final Logger logger = LoggerFactory.getLogger(Dice.class);

    private static final int MAX_DICE_NUMBER = 6;

    private String turn;


    /**
     * Determines who starts the game
     *
     * @param player the player who starts the game
     */
    public void setWhoStarts(String player) {
        turn = player;
    }



    /**
     * Rolls the dice
     *
     * @param player the player that rolls the dice
     */
    public void rollDice(Player player) {
        logger.info(player.getCurrentPlayer() + " is wanting to roll the dice");
        synchronized (this) {
            while (!turn.equals(player.getCurrentPlayer())) { // whilst not your turn

                // wait for the opposition
                logger.debug(player.getCurrentPlayer() + " is waiting for the opposition player");
                try {
                    System.out.println(player.getCurrentPlayer() + " is waiting for the other player: " +
                    player.getOtherPlayer());

                    if(logger.isDebugEnabled()) {
                        logger.debug("Player 1: " + player.getCurrentPlayer() + " is waiting for the other player: " +
                        player.getOtherPlayer());
                    }

                    wait();
                } catch (InterruptedException e) {
                    // can never get here because we're not interrupting...
                    logger.error("{}", e);
                    e.printStackTrace();
                }

            }

            // it is your turn now!
            System.out.println("It is " + player.getCurrentPlayer() + " now to throw the dice");

            throwDice(player);

            System.out.println(player + " throws " + getDiceNumber());
            turn = player.getOtherPlayer();
            notifyAll(); // can use notify also
            logger.debug(player.getCurrentPlayer() + " is signalling he/she finishes his/her turn now");
        }

    }


    /**
     * Throws the dice
     *
     * @param player the player who throws the dice
     */
    private void throwDice(Player player) {
        logger.info("Player {} is throwing the dice", player.getCurrentPlayer());

        // Jeez, give me some time to steady myself (takes a deep breath)
        long simulationTime = ThreadLocalRandom.current().nextLong(10000L);

        if(logger.isTraceEnabled()) {
            logger.trace("Simulating for " + simulationTime + " to simulate the time to throw the dice");
        }
        pause(simulationTime);
    }


    /**
     * Gets a random number as the Dice number in the range of 1 - 6 (inclusive)
     *
     * @return random generated dice number
     */
    private int getDiceNumber(){
        logger.info("Generating random dice number");

        int diceNumber = ThreadLocalRandom.current().nextInt(MAX_DICE_NUMBER) + 1;
        logger.debug("Generated dice number {}", diceNumber);

        return diceNumber;
    }


    /**
     * Helper method to pause (sleep) for a period of time
     *
     * @param time the period of time to stop for
     */
    private void pause(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
