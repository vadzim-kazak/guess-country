package com.jrew.lab.guesscountry.service.message.handler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.service.game.Game;

/**
 * Created by Kazak_VV on 08.08.2014.
 */
public interface MessageHandlerProvider {

    /**
     *
     * @param message
     * @param game
     * @param <T>
     */
    public <T> void handleMessage(GameMessage<T> message, Game game);

    /**
     *
     * @param type
     * @param game
     */
    public void handleMessage(GameMessage.Type type, Game game);
}
