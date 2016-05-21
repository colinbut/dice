/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice.game;

import com.mycompany.dice.DiceGame;
import com.mycompany.dice.model.Dice;
import com.mycompany.dice.model.Player;

/**
 * Represents a Game Player i.e. a player is who is to play game
 *
 * @author colin
 */
public class GamePlayer implements Runnable {

    private Dice dice;
    private Player player;

    /**
     * Constructor
     *
     * @param dice the dice to roll
     * @param player the player
     */
    public GamePlayer(Dice dice, Player player) {
        this.dice = dice;
        this.player = player;
    }


    public Player getGamePlayer() {
        return player;
    }

    @Override
    public void run() {
        for(int i = 0; i < DiceGame.NUMBER_OF_ROUNDS; i++) {
            dice.rollDice(this);
        }
    }
}
