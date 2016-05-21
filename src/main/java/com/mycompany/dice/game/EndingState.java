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
 * Ending state
 *
 * @author colin
 */
public class EndingState implements GameState {

    private static final Logger logger = LoggerFactory.getLogger(EndingState.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void play(DiceGame diceGame) {
        logger.info("[GameState:EndState] " + " Game has ending.");
    }
}
