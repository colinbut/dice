/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice;

import com.mycompany.dice.game.DiceGameContext;

/**
 * Dice Game
 *
 * @author colin
 */
public final class DiceGame {

    public static final int NUMBER_OF_ROUNDS = 6;

    /**
     * Main program
     *
     * @param args
     */
    public static void main(String[] args) {
        DiceGameContext diceGameContext = new DiceGameContext();
        diceGameContext.playGame();
    }
}
