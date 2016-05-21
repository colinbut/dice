/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice.game.states;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Playing state
 *
 * @author colin
 */
public class PlayingState implements GameState {

    private static final Logger logger = LoggerFactory.getLogger(PlayingState.class);

    private static final PlayingState instance = new PlayingState();

    private PlayingState(){
    }

    public static GameState getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void transition() {
        logger.info("[GameState:PlayingState] " + " Game is playing.");
    }
}
