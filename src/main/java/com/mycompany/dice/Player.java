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
public final class Player implements Runnable {

    private Dice dice;
    private String currentPlayer;
    private String otherPlayer;


    /**
     * Constructor
     *
     * @param thisPlayer the current player
     * @param dice the dice
     * @param otherPlayer the other player
     */
    public Player(Dice dice, String thisPlayer, String otherPlayer) {
        this.dice = dice;
        this.currentPlayer = thisPlayer;
        this.otherPlayer = otherPlayer;
    }


    public String getCurrentPlayer() {
        return currentPlayer;
    }


    public String getOtherPlayer() {
        return otherPlayer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player{");
        sb.append("currentPlayer='").append(currentPlayer).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        for(int i = 0; i < DiceGame.NUMBER_OF_ROUNDS; i++) {
            dice.rollDice(this);
        }
    }
}
