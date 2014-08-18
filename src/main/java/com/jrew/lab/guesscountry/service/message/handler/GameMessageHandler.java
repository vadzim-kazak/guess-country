package com.jrew.lab.guesscountry.service.message.handler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.service.game.Game;

/**
 * Created by Kazak_VV on 04.08.2014.
 */
public interface GameMessageHandler<T> {

    /**
     *  @param message
     * @param game
     */
    public void handleMessage(GameMessage<T> message, Game game);

}
