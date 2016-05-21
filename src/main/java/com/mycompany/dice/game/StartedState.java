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
 * @author colin
 */
public class StartedState implements GameState {

    private static final Logger logger = LoggerFactory.getLogger(StartedState.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void play(DiceGame diceGame) {
        logger.info("[GameState:StartedState] " + " started playing game");
        diceGame.setState(new PlayingState());
    }
}
