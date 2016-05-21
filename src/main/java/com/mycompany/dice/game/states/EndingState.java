/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice.game.states;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ending state
 *
 * @author colin
 */
public class EndingState implements GameState {

    private static final Logger logger = LoggerFactory.getLogger(EndingState.class);

    private static final EndingState instance = new EndingState();

    private EndingState() {
    }

    public static GameState getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void transition() {
        logger.info("[GameState:EndState] " + " Game has ended.");
    }
}
