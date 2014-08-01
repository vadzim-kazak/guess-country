package com.jrew.lab.guesscountry.service.game.event;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Kazak_VV on 01.08.2014.
 */
public class GameMessageEvent extends ApplicationEvent {

    /**
     *
     * @param gameMessage
     */
    public GameMessageEvent(GameMessage gameMessage) {
        super(gameMessage);
    }
}
