/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice.game.states;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Started state
 *
 * @author colin
 */
public class StartedState implements GameState {

    private static final Logger logger = LoggerFactory.getLogger(StartedState.class);

    private static final StartedState instance = new StartedState();

    private StartedState() {
    }

    public static GameState getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void transition() {
        logger.info("[GameState:StartedState] " + " started playing game");
    }
}
