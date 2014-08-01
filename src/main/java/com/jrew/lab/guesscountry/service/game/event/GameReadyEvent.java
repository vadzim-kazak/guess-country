package com.jrew.lab.guesscountry.service.game.event;

import com.jrew.lab.guesscountry.service.game.Game;
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
