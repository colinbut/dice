/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice.model;


/**
 * A player
 *
 * @author colin
 */
public final class Player extends Person {

    private String currentPlayer;
    private String otherPlayer;


    /**
     * Constructor
     *
     * @param thisPlayer the current player
     * @param otherPlayer the other player
     */
    public Player(String thisPlayer, String otherPlayer) {
        super(thisPlayer);
        this.currentPlayer = thisPlayer;
        this.otherPlayer = otherPlayer;
    }


    /**
     * Retrieves the current player
     *
     * @return the current player
     */
    public String getCurrentPlayer() {
        return currentPlayer;
    }


    /**
     * Retrieves the opposition player
     *
     * @return the opposite player
     */
    public String getOtherPlayer() {
        return otherPlayer;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player{");
        sb.append("currentPlayer='").append(currentPlayer).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
