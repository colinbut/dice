package com.mycompany.dice;

/**
 * Dice Game
 *
 * @author colin
 */
public class DiceGame {

    public final static int NUMBER_OF_ROUNDS = 6;

    /**
     * Main program
     *
     * @param args
     */
    public static void main( String[] args ) {

        Player player1 = new Player("Joe");
        Player player2 = new Player("Jane");

        Dice.setWhoStarts(Gamers.JOE);

        Thread thread1 = new Thread(player1);
        thread1.start();

        Thread thread2 = new Thread(player2);
        thread2.start();


    }
}
