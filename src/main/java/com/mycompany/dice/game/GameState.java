/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice.game;

import com.mycompany.dice.DiceGame;

/**
 * State of the game
 *
 * @author colin
 */
public interface GameState {

    /**
     * Plays the game and navigating through the
     * various game states
     *
     * @param diceGame the dice game
     */
    void play(DiceGame diceGame);
}
