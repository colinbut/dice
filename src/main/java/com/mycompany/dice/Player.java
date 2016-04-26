/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice;

/**
 * A player
 *
 * @author colin
 */
public class Player implements Runnable {

    private String currentPlayer;
    private String otherPlayer;

    /**
     * Constructor
     *
     * @param thisPlayer the current player
     */
    public Player(String thisPlayer) {
        this.currentPlayer = thisPlayer;
        otherPlayer = currentPlayer.equals(Gamers.JOE) ? Gamers.JANE : Gamers.JOE;
    }

    @Override
    public void run() {
        for(int i = 0; i < DiceGame.NUMBER_OF_ROUNDS; i++) {
            synchronized (Dice.class) {
                while (!Dice.getTurn().equals(currentPlayer)) { //wait for opposition
                    try {
                        System.out.println(currentPlayer + " is waiting for " + otherPlayer);
                        Dice.class.wait(1000); //wait for 1 sec
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Dice.getTurn() + " throws " + Dice.roll());

                Dice.setTurn(otherPlayer);
                Dice.class.notifyAll();
            }
        }
    }
}
