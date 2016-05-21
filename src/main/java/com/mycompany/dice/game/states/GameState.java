/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice.game.states;

/**
 * State of the game
 *
 * @author colin
 */
public interface GameState {

    /**
     * Plays the game and navigating through the
     * various game states
     */
    void transition();
}
