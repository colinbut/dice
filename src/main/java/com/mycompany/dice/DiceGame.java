package com.mycompany.dice;

/**
 * Dice Game
 *
 * @author colin
 */
public class DiceGame {

    static final int NUMBER_OF_ROUNDS = 6;

    /**
     * Main program
     *
     * @param args
     */
    public static void main(String[] args) {

        Dice dice = new Dice();

        Player player1 = new Player(dice, "Joe", "Jane");
        Player player2 = new Player(dice, "Jane", "Joe");

        dice.setWhoStarts(player1.getCurrentPlayer()); //let's make player 1 start the game

        new Thread(player1).start();
        new Thread(player2).start();

    }
}
