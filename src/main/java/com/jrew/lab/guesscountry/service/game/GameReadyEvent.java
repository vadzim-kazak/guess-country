package com.jrew.lab.guesscountry.service.game;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Kazak_VV on 01.08.2014.
 */
public class GameReadyEvent extends ApplicationEvent {

    /**
     *
     * @param game
     */
    public GameReadyEvent(Game game) {
        super(game);
    }
}
