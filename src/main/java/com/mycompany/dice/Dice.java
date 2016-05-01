/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Abstracting how the dice rolls and decides who plays it
 *
 * @author colin
 */
public final class Dice {

    private static final int MAX_DICE_NUMBER = 6;

    private String turn;


    public void setWhoStarts(String player) {
        turn = player;
    }


    /**
     * Gets a random number as the Dice number in the range of 1 - 6 (inclusive)
     *
     * @return random generated dice number
     */
    private int getDiceNumber(){
        return ThreadLocalRandom.current().nextInt(MAX_DICE_NUMBER) + 1;
    }


    /**
     *
     * @param player
     */
    public void rollDice(Player player) {

        synchronized (this) {
            while (!turn.equals(player.getCurrentPlayer())) { // whilst not your turn

                // wait for the opposition
                try {
                    System.out.println(player.getCurrentPlayer() + " is waiting for the other player: " +
                    player.getOtherPlayer());
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            // it is your turn now!
            System.out.println("It is " + player.getCurrentPlayer() + " now to throw the dice");

            // Jeez, give me some time to steady myself (takes a deep breath)
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(10000L));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(player + " throws " + getDiceNumber());
            turn = player.getOtherPlayer();
            notifyAll(); // can use notify also
        }

    }



}
