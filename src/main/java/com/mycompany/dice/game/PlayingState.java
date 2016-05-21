/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice.game;

import com.mycompany.dice.DiceGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Playing state
 *
 * @author colin
 */
public class PlayingState implements GameState {

    private static final Logger logger = LoggerFactory.getLogger(PlayingState.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void play(DiceGame diceGame) {
        logger.info("[GameState:PlayingState] " + " Game is playing.");
        diceGame.setState(new EndingState());
    }
}
