/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice;

import java.util.Random;

/**
 * Abstracting how the dice rolls and decides who plays it
 *
 * @author colin
 */
public final class Dice {

    private static String turn;

    public synchronized static String getTurn(){
        return turn;
    }

    public synchronized static void setTurn(String player) {
        turn = player;
    }

    public static void setWhoStarts(String player) {
        turn = player;
    }

    private Dice() {}

    public static Random random = new Random();

    public static int roll(){
        return random.nextInt(6) + 1;
    }

}
